package org.landy.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtil {

    public static Object getProperty(Object bean, String name) {
        try {
            return BeanUtils.getProperty(bean, name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void setProperty(Object bean, String name, Object value) {
        try {
            BeanUtils.setProperty(bean, name, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Class<?> getPropertyType(Object bean, String name) {
        try {
            return PropertyUtils.getPropertyType(bean, name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

}
