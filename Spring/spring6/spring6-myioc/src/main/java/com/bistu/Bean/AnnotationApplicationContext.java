package com.bistu.Bean;

import com.bistu.anno.Bean;
import com.bistu.anno.Di;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {
    private Map<Class, Object> beanFactory = new HashMap<>();
    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //设置包扫描规则，若遇见有Bean注解的类，则通过反射实例化
    public AnnotationApplicationContext(String basePackage) throws Exception {
        String packagePath = basePackage.replaceAll("\\.", "\\\\");
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String path = URLDecoder.decode(url.getFile(), "utf-8");
            rootPath = path.substring(0, path.length() - basePackage.length());
            loadBean(new File(path));
            loadDi();
        }
    }


    private void loadBean(File file) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                return;
            }
            for (File childFile : childFiles) {
                if (childFile.isDirectory()) {
                    loadBean(childFile);
                }
                if (childFile.isFile()) {
                    String pathWithClass = childFile.getAbsolutePath().substring(rootPath.length() - 1);
                    if (pathWithClass.contains(".class")) {
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        Class<?> Clazz = Class.forName(allName);
                        if (!Clazz.isInterface()) {
                            Bean annotation = Clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                Object bean = Clazz.getConstructor().newInstance();
                                if (Clazz.getInterfaces().length > 0) {
                                    beanFactory.put(Clazz.getInterfaces()[0], bean);
                                } else {
                                    beanFactory.put(Clazz, bean);
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    private void loadDi() throws IllegalAccessException {
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entries) {
            Object obj = entry.getValue();
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.getAnnotation(Di.class) != null) {
                    field.setAccessible(true);
                    field.set(obj, beanFactory.get(field.getType()));
                }
            }
        }
    }
}
