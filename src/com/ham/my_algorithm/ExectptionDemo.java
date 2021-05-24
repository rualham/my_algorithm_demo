package com.ham.my_algorithm;

public class ExectptionDemo {

    public static void main(String[] args) {
        try {
            int a = doStuff(-1);
            System.out.println("a = " + a);
            int b = doStuff(100);
            System.out.println("b = " + b);

            int c = doStuff();
            System.out.println("c = " + c);
            System.out.println(doStuff2().getName());

            try {
                doSomething();
            } catch (RuntimeException e) {
                System.out.println("这里永远都不会到达!!!!!!！");
            }
        } catch (Exception e) {
            System.out.println("这里是永远都不会到达的");
        }
    }

    public static int doStuff(int _p) throws Exception {
        try {
            if (_p < 0) {
                throw new Exception("数据格式错误");
            } else {
                return _p;
            }
        } catch (Exception e) {
            //异常处理
            throw e;
        } finally {
            return -1;
        }
    }

    public static int doStuff() {
        int a = 1;
        try {
            return a;
        } catch (Exception e) {

        } finally {
            //重新修改一下返回值
            a = -1;
            System.out.println("a = " + a);
        }
        return 0;
    }

    public static Student doStuff2() {
        Student person = new Student();
        person.setName("张三");
        try {
            return person;
        } catch (Exception e) {
        } finally {
            //重新修改一下返回值
            person.setName("李四");
        }
        person.setName("王五");
        return person;
    }

    static class Student {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static void doSomething() {
        try {
            //正常抛出异常
            throw new RuntimeException();
        } finally {
            //告诉JVM:该方法正常返回
            return;
        }
    }
}
