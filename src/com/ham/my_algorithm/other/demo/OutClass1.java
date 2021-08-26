package com.ham.my_algorithm.other.demo;

public class OutClass1 {
    public int oid;
    public String oname;
    public static String oage;
//    只有静态内部类才能够定义静态的成员变量与成员方法
//    静态内部类只能引用外部类中的静态的成员（变量或方法），而不能够访问非静态的变量。
    public static class InnerStaticClass1 {
        public int iid;
        public String iname;

        public static void main(String[] args) {
            oage = "f";
        }
    }

    public class InnerClass2 {
        public int iid;
        public String iname;
//        public static String name;

        public void mainw(String[] args) {
            oname = "1";
        }
    }
}
