package com.ham.my_algorithm.mythread;

public interface ICanImplete {

    String a = "3";

   public void a();
    void b();
    void c();
    void d();

    default void sayHello(){
        System.out.println("Hello World");
    }

}
