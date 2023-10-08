package com.lemon.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * Created by lemoon on 2023/10/7 22:28
 */
public class LemonApplicationContext {

    private Class configClass;

    public LemonApplicationContext(Class configClass) {
        this.configClass = configClass;

        //扫描
        if (configClass.isAnnotationPresent(ComponentScan.class)) {

            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);

            String path = componentScanAnnotation.value();  //扫描路径  com.lemon.service

            path = path.replace(".", "/");

            ClassLoader classLoader = LemonApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);

            File file = new File(resource.getFile());
//            /Users/lemoon/Documents/IDEA/mygithub/spring-onhand/out/production/spring-onhand/com/lemon/service

            System.out.println(file);

            if (file.isDirectory()) {
                File[] files = file.listFiles();

                for (File f : files) {
                    String fileName = f.getAbsolutePath();
                    System.out.println(fileName);
                    if (fileName.endsWith(".class")) {

                        String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));

                        className = className.replace("/", ".");

                        System.out.println(className);

                        Class<?> clazz = null;

                        try {
                            clazz = classLoader.loadClass(className);

                            System.out.println(clazz);
                            if (clazz.isAnnotationPresent(Component.class)) {
                                //Bean
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }
        }

    }

    public Object getBean(String beanName) {
        return null;
    }
}
