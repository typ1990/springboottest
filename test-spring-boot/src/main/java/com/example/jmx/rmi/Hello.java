package com.example.jmx.rmi;

import java.io.Serializable;

public class Hello implements HelloMBean {

    private String name;

    @Override
    public synchronized void setName(String name) {
        this.name = name;
    }
    @Override
    public synchronized String getName() {
        return name;
    }
    @Override
    public synchronized void sayHello() {
        System.out.println("Hello," + name);
    }

}