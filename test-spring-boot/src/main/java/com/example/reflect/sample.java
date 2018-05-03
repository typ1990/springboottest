package com.example.reflect;

public class sample {
    public static void main(String[] args){
        //得到类的简写名称
        System.out.println("sample.class.getSimpleName():  "+sample.class.getSimpleName());

        //得到对象的全路径
        System.out.println("sample.class:  "+sample.class);

        //得到对象的类模板示例，也就是Class
        System.out.println("sample.class.getClass():  "+sample.class.getClass());

        //得到Class类的名称
        System.out.println("sample.class.getClass().getName():  "+sample.class.getClass().getName());
    }
}
