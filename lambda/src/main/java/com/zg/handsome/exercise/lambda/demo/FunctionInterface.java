package com.zg.handsome.exercise.lambda.demo;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FunctionInterface {

    @FunctionalInterface
    public interface Checker<T extends String> {
        Boolean check(T t);
    }

    @FunctionalInterface
    interface Out<T>{
        void achievement(T t);
    }

    @Test
    public void testLambda() {
        List<String> demoList = Arrays.asList("格瑞", "Mr.ming", "金");
        rollCall(demoList,checker -> checker.startsWith("m"),out -> System.out.println(out));
    }

    public void rollCall(List<? extends String> list, Checker checker,Out out){
        for(String name : list){
            if(checker.check(name)){
                out.achievement(name);
            }
        }
    }

}
