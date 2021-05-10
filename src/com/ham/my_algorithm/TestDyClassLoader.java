package com.ham.my_algorithm;

import java.io.*;

public class TestDyClassLoader extends ClassLoader {
    private String name;

    public TestDyClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    public TestDyClassLoader(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestDyClassLoader{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File("Student.class"));
            int c = 0;
            while (-1 != (c = is.read())) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.defineClass(name, data, 0, data.length);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> clazz = null;
        ClassLoader system = getSystemClassLoader();
        try {
            clazz = system.loadClass(name);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
//        if (clazz != null)
//            return clazz;
        clazz = findClass(name);
        return clazz;
    }

    public static void main(String[] args) {
//        Student testClass = new Student();
//        testClass.test();
        TestDyClassLoader loader = new TestDyClassLoader(TestDyClassLoader.class.getClassLoader(), "TestDyClassLoader");
        Class clazz;
        try {
            clazz = loader.loadClass("com.ham.my_algorithm.Student");
            Object object = clazz.newInstance();

            TestDyClassLoader testClass1 = new TestDyClassLoader("TestDyClassLoader");
            testClass1.test();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void test() {

        System.out.println(this.getClass().getClassLoader().toString());
        System.out.println(this.getClass().getClassLoader());
    }
}

