package com.study.ch1.duck;

import com.study.ch1.Duck;
import com.study.ch1.behavior.FlyNoWay;
import com.study.ch1.behavior.Quack;

/**
 * @Author heyu
 * @Date 2021/4/6 16:46
 * @Package com.study.ch1.duck
 * @Description
 **/
public class WoodDuck extends Duck {
    public WoodDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }
}
