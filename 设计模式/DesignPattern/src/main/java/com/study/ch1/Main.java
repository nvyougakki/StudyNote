package com.study.ch1;

import com.study.ch1.behavior.FlyWithRocket;
import com.study.ch1.duck.BlueDuck;
import com.study.ch1.duck.WoodDuck;

/**
 * @Author heyu
 * @Date 2021/4/6 18:03
 * @Package com.study.ch1
 * @Description
 **/
public class Main {

    public static void main(String[] args) {
        Duck duck = new BlueDuck();
        duck.performFly();
        duck.performQuack();

        duck = new WoodDuck();
        duck.performQuack();
        duck.performFly();

        duck.setFlyBehavior(new FlyWithRocket());
        duck.performFly();


    }

}
