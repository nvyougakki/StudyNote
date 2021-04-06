package com.study.ch1;

import com.study.ch1.behavior.FlyBehavior;
import com.study.ch1.behavior.QuackBehavior;
import lombok.Data;

/**
 * @Author heyu
 * @Date 2021/4/6 16:36
 * @Package com.study.ch1
 * @Description
 **/
@Data
public abstract class Duck {

    private String name;

    private String height;

    protected FlyBehavior flyBehavior;

    protected QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    //外观
    public void display(){}

    //叫声
    public void quack(){}

    //游泳
    public void swim(){}

    //飞行
    public void fly(){}
}
