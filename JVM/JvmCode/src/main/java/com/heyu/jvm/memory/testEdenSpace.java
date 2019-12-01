package com.heyu.jvm.memory;

/**
 * @ClassName testEdenSpace
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/12/1 20:20
 */
public class testEdenSpace {

    public static final int _1MB = 1024 * 1024;
    /**
     * VM参数: -verbose:gc -Xms20M -Xmx20M Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void main(String[] args) throws InterruptedException {
        byte [] allocation1,allocation2,allocation3,allocation4;
//        Thread.sleep(20_000);
        allocation1 = new byte[2* _1MB];
        allocation2 = new byte[2* _1MB];
        allocation3 = new byte[2* _1MB];
        allocation4 = new byte[4* _1MB];

       /* while (true){
            Thread.sleep(20_000);
        }*/
    }

}
