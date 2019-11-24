package com.heyu.jvm.demo1;

import java.io.IOException;
import java.io.InputStream;

/**
 * ͬһ���౻��ͬ����������أ�ʵ����instanceof����false
 * ���Ҵ�ӡ���������Ҳ��һ��
 * ʹ��-XX:+TraceClassLoading�����ļ��أ��౻��������
 *
 * @ClassName ClassLoadTest2
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/14 23:49
 */
public class ClassLoadTest2 {

    public void printTest(Class<?> clazz){
        System.out.println(clazz.getClassLoader());
    }

    public static void main(String[] args) throws Exception {
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

        Class<?> clazz = classLoader.loadClass("com.heyu.jvm.demo1.ClassLoadTest2");
        Class<?> clazz1 = classLoader.loadClass("com.heyu.jvm.demo1.MyChild4");
        Object obj = clazz.newInstance();
        clazz.getMethod("printTest").invoke(obj, new Object[]{MyChild4.class});
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoadTest2);
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(ClassLoadTest2.class.getClassLoader());

    }


}
