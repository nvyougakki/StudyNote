package com.heyu.jvm.demo1;

/**
 * @ClassName demo2
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/14 11:19
 */
//Test3����ʼ��
//��Ϊ��ʱi�Ǳ����ڳ����������Test.i��ֱֵ�ӽ���Demo3�ĳ�����
//�鿴Demo3������ָ����
//iconst_1
public class Demo3 {

    public static void main(String[] args) {
        System.out.println(Test3.b);
    }

}

class Test3{
    public static final byte b = 0;
    public static final short s = 130;
    public static final int i = 8519680;
    public static final long l = 268435456l;



    static {
        System.out.println("init static area");
    }
}
