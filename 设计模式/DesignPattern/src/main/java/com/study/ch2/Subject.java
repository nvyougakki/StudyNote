package com.study.ch2;

/**
 * @Author heyu
 * @Date 2021/4/14 17:17
 * @Package com.study.ch2
 * @Description
 **/
public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();

}
