package com.ham.my_algorithm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {
    private String mLibPath;

    public MyClassLoader(String path) {
        mLibPath = path;
    }

    /**
     * 双亲委派逻辑，父加载器读不到Class才会调用此方法
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data;
        try {
            data = readClassFile(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    /**
     * 绕过双亲委派逻辑，直接获取Class
     */
    public Class<?> createClass(String name) throws Exception {
        byte[] data;
        data = readClassFile(name);
        return defineClass(name, data, 0, data.length);
    }

    /**
     * 读取Class文件
     */
    private byte[] readClassFile(String name) throws Exception {
        String fileName = getFileName(name);
        File file = new File(mLibPath, fileName);
        FileInputStream is = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len = 0;
        while ((len = is.read()) != -1) {
            bos.write(len);
        }
        byte[] data = bos.toByteArray();
        is.close();
        bos.close();
        return data;
    }

    //获取要加载 的class文件名
    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name + ".class";
        } else {
            return name.substring(index + 1) + ".class";
        }
    }

    static void testClassLoader() throws Exception{
        MyClassLoader diskLoader = new MyClassLoader("D:\\tmp\\");
        //双亲委派
//        Class<?> c = diskLoader.loadClass("com.ham.my_algorithm.Student");

        //绕过双亲委派
        Class<?> c = diskLoader.createClass("com.ham.my_algorithm.Student");
        if(c != null){
            try {
                Object obj = c.newInstance();
                Method method = c.getDeclaredMethod("hello",null);
                method.invoke(obj, null);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        diskLoader.test();
    }

    public void test() {
        System.out.println(this.getClass().getClassLoader().toString());
        System.out.println(this.getClass().getClassLoader());
    }

    public static void main(String[] args) throws Exception {
        testClassLoader();
    }
}
