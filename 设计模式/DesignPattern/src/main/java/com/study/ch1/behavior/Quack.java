package com.study.ch1.behavior;

/**
 * @Author heyu
 * @Date 2021/4/6 16:51
 * @Package com.study.ch1.behavior
 * @Description
 **/
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
