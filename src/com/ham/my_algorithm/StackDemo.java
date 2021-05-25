package com.ham.my_algorithm;

import java.util.Enumeration;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        stackMethod();
    }

    //stack operate
    public static void stackMethod() {
        //定义一个Integer泛型的Stack
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("新建栈stack是否为空 : " + (stack.empty() ? "空" : stack.size()));
        //push : 把项压入堆栈顶部，返回值泛型指定的类型
        //此处将1到5压入栈中
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("将1到5按顺序压入栈中后为：" + stack);
        //empty : 测试堆栈是否为空，size() == 0，返回值boolean
        System.out.println("值为1~5的栈中stack是否为空 : " + (stack.empty() ? "空" : stack.size()));
        //search : 返回对象在堆栈中的位置，以 1 为基数，参数：search(Object o) ，返回值int
        int oStack = stack.search(3);
        System.out.println("查找栈stack中对象3的位置elementId为 : " + oStack);
        //peek : 查看堆栈顶部的对象，但不从堆栈中移除它，返回值泛型指定的类型
        int topElement = stack.peek();
        System.out.println("查看stack的栈顶元素为 : " + topElement);
        System.out.println("peek操作stack后为 : " + stack);
        //pop : 移除堆栈顶部的对象，并作为此函数的值返回该对象，返回值泛型指定的类型
        int oRemove = stack.pop();
        System.out.println("移除stack栈顶的元素为 : " + oRemove);
        System.out.println("pop操作移除stack栈顶元素后为 : " + stack);

        //创建堆栈对象
    /*    Stack stack = new Stack();
        System.out.println("aaaa,bbbb,cccc三个元素入栈");
        //向栈中压入字符串aaaa
        stack.push("aaaa");
        //显示栈中的所有元素
        printStack(stack);
        stack.push("bbbb");
        printStack(stack);
        stack.push("cccc");
        printStack(stack);
        String s = new String("aaaa");
        System.out.println("元素aaaa在堆栈的位置" + stack.search(s));
        s = new String("bbbb");
        System.out.println("元素bbbb在堆栈的位置" + stack.search(s));
        System.out.println("aaaa,bbbb,cccc三个元素出栈");
        System.out.println("元素" + stack.pop() + "出栈");
        printStack(stack);
        System.out.println("元素" + stack.pop() + "出栈");
        printStack(stack);
        System.out.println("元素" + stack.pop() + "出栈");
        printStack(stack);*/

    }

    private static void printStack(Stack stack) {
        if (stack.empty()) {
            System.out.println("堆栈是空的,没有元素");
        } else {
            System.out.print("堆栈中的元素:");
            //得到Stack中的枚举对象
            Enumeration items = stack.elements();
            //显示枚举(stack)中的所有元素
            while (items.hasMoreElements()) {
                System.out.print(items.nextElement() + "");
            }
//            System.out.print(stack+ "");
        }
        System.out.println();//换行
/*
        aaaa,bbbb,cccc三个元素入栈
        堆栈中的元素:[aaaa]
        堆栈中的元素:[aaaa, bbbb]
        堆栈中的元素:[aaaa, bbbb, cccc]
        元素aaaa在堆栈的位置3
                元素bbbb在堆栈的位置2
        aaaa,bbbb,cccc三个元素出栈
        元素cccc出栈
        堆栈中的元素:[aaaa, bbbb]
        元素bbbb出栈
        堆栈中的元素:[aaaa]
        元素aaaa出栈
                堆栈是空的,没有元素*/
    }
}
