package com.heyu.demo1;

/**
 * @ClassName Demo7
 * @Description TODO
 * @Author Å®ÓÑGakki
 * @Date 2019/9/15 20:52
 */
public class Demo7 {

    public static void main(String[] args) throws Exception{
        ClassLoaderTest3 myClassLoader1 = new ClassLoaderTest3("classload1");
        myClassLoader1.setPath("E:\\");
        Class<?> personClazz = myClassLoader1.loadClass("com.heyu.demo1.Person");
        Class<?> clazz = myClassLoader1.loadClass("com.heyu.demo1.Dog");

        System.out.println(personClazz.getClassLoader());
        System.out.println(clazz.getClassLoader());

        clazz.newInstance();

//        ClassLoaderTest3 myClassLoader2 = new ClassLoaderTest3(myClassLoader1, "classload2");
//        myClassLoader2.loadClass("com.heyu.demo1.Dog");

        //myClassLoader1 = null;
        //personClazz = null;
        //System.gc();

        personClazz.newInstance();

    }

}
