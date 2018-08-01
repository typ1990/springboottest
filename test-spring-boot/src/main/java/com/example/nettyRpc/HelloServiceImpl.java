package com.example.nettyRpc;

import com.nettyrpc.server.RpcService;

@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {
    public HelloServiceImpl(){}

    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }

    @Override
    public String hello(Person person) {
        return "Hello! " + person.getFirstName() + " " + person.getLastName();
    }
}
