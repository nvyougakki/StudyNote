package com.heyu.demo1;

/**
 * @ClassName Demo5
 * @Description TODO
 * @Author Å®ÓÑGakki
 * @Date 2019/9/14 13:00
 */
public class Demo5 {

    public static void main(String[] args) {
        System.out.println(TestInstance.getInstance());
        System.out.println("count1:" + TestInstance.count1);
        System.out.println("count2:" + TestInstance.count2);
    }
}


class TestInstance{

    //private static TestInstance instance = new TestInstance();

    public static int count1 = 0;
    //public static int count2 = 0;

    private static TestInstance instance = new TestInstance();
    public static int count2 = 0;

    private TestInstance(){
        count1++;
        count2++;
        System.out.println(count1);
        System.out.println(count2);
    }

    static {
        System.out.println("init----");
    }



    public static TestInstance getInstance(){
        return instance;
    }

}