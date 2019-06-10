package com.zg.handsome.exercise.lambda.test;


import org.junit.Test;

import java.util.Stack;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class TestDemo {


    public static void main(String[] args) {

    }

    /**
     * ==和equals测试
     */
    @Test
    public void stringTest() {
        String str1 = "1";
        String str2 = "1";
        StringBuffer sb = new StringBuffer("1");
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
        System.out.println(sb.equals(str1));
        System.out.println(str1.equals(sb));
        System.out.println(str1.equals(sb.toString()));
        System.out.println(sb.toString() == str1);
    }

    @Test
    public void mathTest() {
        System.out.println(Math.round(-1.4));
        System.out.println(Math.round(-1.5));
        System.out.println(Math.round(-1.6));
        System.out.println(Math.round(2.4));
        System.out.println(Math.round(2.5));
        System.out.println(Math.round(2.6));
        System.out.println();
        System.out.println(10 >> 2);
        System.out.println(10 >> 3);
        System.out.println(10 >> 4);
        System.out.println(10 >> 1);
    }

    /**
     * for循环交换字符串
     */
    @Test
    public void reverseByFor() {
        String string = "Test";
        int le = string.length();
        char[] befr = string.toCharArray();
        char[] after = new char[le];
        for (int i = 0; i < le; i++) {
            after[i] = befr[le - (i + 1)];
        }
        System.out.println(new String(after));

        StringBuffer sb = new StringBuffer(string);
        sb.reverse().toString();
    }

    /**
     * 用入栈出栈交换字符串
     */
    @Test
    public void reverseByStack() {
        String string = "Test";
        Stack<Character> stack = new Stack<>();
        int le = string.length();
        StringBuffer sb = new StringBuffer();
        char[] ch = string.toCharArray();
        for (int i = 0; i < le; i++) {
            stack.push(ch[i]);
        }

        for (int i = 0; i < le; i++) {
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb);
    }

    /**
     * 用位算法交换字符串
     */
    @Test
    public void reverseByBitMath() {
        String string = "reverse测试";
        int le = string.length();
        char[] ch = string.toCharArray();
        for (int i = 0; i <= le >> 1; i++) {
            ch[i] ^= ch[le - i - 1];
            ch[le - i - 1] ^= ch[i];
            ch[i] ^= ch[le - i - 1];
        }
        System.out.println(new String(ch));
    }



}
