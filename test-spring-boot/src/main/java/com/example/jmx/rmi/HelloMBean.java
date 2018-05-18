package com.example.jmx.rmi;

import java.io.Serializable;

public interface HelloMBean {
    public void setName(String name);

    public String getName();

    public void sayHello();

}