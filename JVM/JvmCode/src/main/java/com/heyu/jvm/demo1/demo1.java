package com.heyu.jvm.demo1;

import java.util.Random;

/**
 * @ClassName demo1
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/13 18:58
 */
/* *
 * �ӽӿڻ������ʼ��ʱ�����ӿڲ���ʼ��
 * ֻ�е����ø��ӿڵ��ೣ��ʱ��ų�ʼ��
 **/
public class demo1 {

    public static void main(String[] args) {
        System.out.println(Children.i);
    }

}

interface MyParent{
    Thread t = new Thread(){
        {
            System.out.println("parent init");
        }
    };
    int par = 1;
}
interface Children extends MyParent{
    int i = new Random().nextInt(5);
    Thread t = new Thread(){
        {
            System.out.println("child init");
        }
    };
}
