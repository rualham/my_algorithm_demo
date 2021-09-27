package com.ham.my_algorithm.mythread;

public class IClass implements ICanImplete{


    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }

    @Override
    public void d() {

    }

    @Override
    public void sayHello() {

    }

    public static void main(String[] args) {
        ICanImplete i =new IClass();
        System.out.println("i = " + i.ab);
        i.sayHello();
    }
}
