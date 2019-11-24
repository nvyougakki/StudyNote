package com.heyu.jvm.demo1;

import java.io.*;

/**
 * @ClassName ClassLoaderTest3
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/15 14:39
 */
public class ClassLoaderTest3 extends ClassLoader {

    private static final String classFileTail = ".class";

    private String path;

    private String classLoaderName;

    public ClassLoaderTest3(String classLoaderName) {
        super(getSystemClassLoader());
        this.classLoaderName = classLoaderName;
    }

    public ClassLoaderTest3(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte [] bytes = loadClassData(name);

        return defineClass(name,bytes, 0, bytes.length);
    }


    public byte[] loadClassData(String loadClassName){
        InputStream ips = null;

        byte [] bytes = null;

        try {
            String loadClassPath = loadClassName.replace(".", File.separator);
            ips = new FileInputStream(new File(path + loadClassPath + classFileTail));
            bytes = new byte[ips.available()];
            ips.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ips != null)
                {
                    ips.close();
                    ips = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bytes;
    }

    @Override
    public String toString() {
        return classLoaderName;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoaderTest3 myClassLoader = new ClassLoaderTest3("my class loader");
        myClassLoader.setPath("E:\\");

        Class<?> clazz = myClassLoader.loadClass("com.heyu.jvm.demo1.demo1");

        ClassLoaderTest3 myClassLoader2 = new ClassLoaderTest3(myClassLoader, "my class loader2");
        myClassLoader2.setPath("E:\\");

        Class<?> clazz2 = myClassLoader2.loadClass("com.heyu.jvm.demo1.demo1");

        Object obj1 = clazz.newInstance();

        Object obj2 = clazz2.newInstance();


        System.out.println(clazz.equals(clazz2));
        System.out.println(clazz.isInstance(clazz2.newInstance()));

        System.out.println(Object.class.isInstance(clazz));

        System.out.println(clazz.getClassLoader());

        System.out.println(clazz2.getClassLoader());
    }



}
