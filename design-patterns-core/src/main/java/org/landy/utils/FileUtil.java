package org.landy.utils;

import org.apache.commons.io.IOUtils;
import org.landy.constants.Constants;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class FileUtil {

    public static String loadFileContentByClassPath(String fileName) throws IOException{
        Resource[] resources = getResources(fileName);
        if (resources.length == 0) {
            throw new FileNotFoundException(fileName);
        }
        InputStream io = resources[0].getInputStream();
        byte[] contents = new byte[102400];
        IOUtils.read(io, contents);
        IOUtils.closeQuietly(io);
        return new String(contents);
    }

    private static Resource[] getResources(String fileName) throws IOException {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        return patternResolver.getResources(fileName);
    }

    public static String getFilePathByClassPath(String fileName) {
        java.net.URL url = FileUtil.class.getResource(fileName);
        if(url == null) {
            url = FileUtil.class.getClassLoader().getResource(fileName);
            if(url == null) {
                url = Thread.currentThread().getContextClassLoader().getResource(fileName);
            }
        }
        String filePath = url.getFile();
        return filePath;
    }

    public static boolean isTextFile(String fileName) {
        return fileName.toLowerCase().endsWith(Constants.FILE_TYPE_TXT);
    }

    public static File buildFile(String path) throws Exception {
        File file = new File(path);

        File folder = file.getParentFile();
        if (folder != null && !folder.exists()) {
            folder.mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        return file;
    }

    public static void main(String[] args) throws Exception{

        System.out.println(FileUtil.getFilePathByClassPath("/"));
    }

}
