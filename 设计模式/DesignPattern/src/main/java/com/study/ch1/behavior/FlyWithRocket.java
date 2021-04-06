package com.study.ch1.behavior;

/**
 * @Author heyu
 * @Date 2021/4/6 18:04
 * @Package com.study.ch1.behavior
 * @Description
 **/
public class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("🚀飞行");
    }
}
