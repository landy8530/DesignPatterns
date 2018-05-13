package org.landy.utils;


import org.landy.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author landyl
 * @create 12:51 PM 05/10/2018
 */
public class PackageUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(PackageUtil.class);
    private final static String CLASS_SUFFIX = ".class";
    /**
     * scan the all class file in the package
     *
     * @param pkg
     * @return
     */
    public static Set<Class<?>> getClzFromPkg(String pkg) {
        Set<Class<?>> classes = new LinkedHashSet<>();

        String pkgDirName = pkg.replace('.', '/');
        try {
            Enumeration<URL> urls = PackageUtil.class.getClassLoader().getResources(pkgDirName);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {//
                    String filePath = URLDecoder.decode(url.getFile(), Constants.ENCODING_UTF8);//
                    findClassesByFile(pkg, filePath, classes);
                } else if ("jar".equals(protocol)) {//
                    JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
                    findClassesByJar(pkg, jar, classes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }
    /**
     * scan the all class file in the package
     *
     * @param pkgName the name of the package
     * @param pkgPath the absolute file path
     * @param classes the set of the classes
     */
    private static void findClassesByFile(String pkgName, String pkgPath, Set<Class<?>> classes) {
        File dir = new File(pkgPath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // filter class file
        File[] dirFiles = dir.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith(CLASS_SUFFIX));
        if (dirFiles == null || dirFiles.length == 0) {
            return;
        }
        String className;
        Class clz;
        for (File f : dirFiles) {
            if (f.isDirectory()) {
                findClassesByFile(pkgName + "." + f.getName(),pkgPath + "/" + f.getName(),classes);
                continue;
            }
            //
            className = f.getName();
            className = className.substring(0, className.length() - 6);
            //
            clz = loadClass(pkgName + "." + className);
            if (clz != null) {
                classes.add(clz);
            }
        }
    }
    /**
     * scan the all class file in the package
     * @param pkgName
     * @param jar
     * @param classes
     */
    private static void findClassesByJar(String pkgName, JarFile jar, Set<Class<?>> classes) {
        String pkgDir = pkgName.replace(".", "/");
        Enumeration<JarEntry> entry = jar.entries();

        JarEntry jarEntry;
        String name, className;
        Class<?> clazz;
        while (entry.hasMoreElements()) {
            jarEntry = entry.nextElement();

            name = jarEntry.getName();
            if (name.charAt(0) == '/') {
                name = name.substring(1);
            }
            if (jarEntry.isDirectory() || !name.startsWith(pkgDir) || !name.endsWith(CLASS_SUFFIX)) {
                continue;
            }
            // convert to package format
            className = name.substring(0, name.length() - 6);
            clazz = loadClass(className.replace("/", "."));
            if (clazz != null) {
                classes.add(clazz);
            }
        }
    }

    private static Class<?> loadClass(String fullClzName) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(fullClzName);
        } catch (ClassNotFoundException e) {
            LOGGER.error("load class error! clz: {}, e:{}", fullClzName, e);
        }
        return null;
    }
}
