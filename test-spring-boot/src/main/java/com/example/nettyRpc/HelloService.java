package com.example.nettyRpc;

public interface HelloService {
    String hello(String name);
    String hello(Person person);
}
