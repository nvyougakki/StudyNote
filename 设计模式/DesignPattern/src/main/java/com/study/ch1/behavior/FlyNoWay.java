package com.study.ch1.behavior;

/**
 * @Author heyu
 * @Date 2021/4/6 16:50
 * @Package com.study.ch1.behavior
 * @Description
 **/
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞行");
    }
}
