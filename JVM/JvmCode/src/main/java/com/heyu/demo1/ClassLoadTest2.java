package com.heyu.demo1;

import java.io.IOException;
import java.io.InputStream;

/**
 * 同一个类被不同类加载器加载，实例后instanceof返回false
 * 并且打印的类加载器也不一样
 * 使用-XX:+TraceClassLoading监控类的加载，类被加载两次
 *
 * @ClassName ClassLoadTest2
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/14 23:49
 */
public class ClassLoadTest2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream ips = getClass().getResourceAsStream(fileName);
                    if(ips == null)
                        return super.loadClass(name);
                    byte[] b = new byte[ips.available()];
                    ips.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }


            }

        };

        Class<?> clazz = classLoader.loadClass("com.heyu.demo1.ClassLoadTest2");
        Object obj = clazz.newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.heyu.demo1.ClassLoadTest2);
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(com.heyu.demo1.ClassLoadTest2.class.getClassLoader());

    }

}
