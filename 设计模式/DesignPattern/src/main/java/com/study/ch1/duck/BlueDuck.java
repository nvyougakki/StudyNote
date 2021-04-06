package com.study.ch1.duck;

import com.study.ch1.Duck;
import com.study.ch1.behavior.FlyWithWing;
import com.study.ch1.behavior.Quack;

/**
 * @Author heyu
 * @Date 2021/4/6 16:45
 * @Package com.study.ch1.duck
 * @Description
 **/
public class BlueDuck extends Duck {

    public BlueDuck() {
        flyBehavior = new FlyWithWing();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("green");
    }
}
