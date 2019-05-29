package com.zg.handsome.design.patterns.proxy;

public class ProxySubject implements Subject{


    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        if (realSubject == null) {
            this.realSubject = realSubject;
        }

    }

    @Override
    public void eat(String foot) {
        realSubject.eat(foot);
    }

    @Override
    public void read(String book) {

    }

    @Override
    public void sing(String song) {

    }

    @Override
    public void dance(String dance) {

    }
}
