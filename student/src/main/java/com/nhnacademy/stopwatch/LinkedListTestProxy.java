package com.nhnacademy.stopwatch;

import java.lang.reflect.Method;
import java.util.Objects;

public class LinkedListTestProxy implements PerformanceTestable {
    private final PerformanceTestable performanceTestable;

    public LinkedListTestProxy(PerformanceTestable performanceTestable) {
        this.performanceTestable = performanceTestable;
    }

    @Override
    public void test() {
        if(hasStopWatch()) {
            long start = System.currentTimeMillis();
            System.out.println("##Linkedlist 시간측정 시작: " + start );
            performanceTestable.test();
            long end = System.currentTimeMillis();
            System.out.println("##Linkedlist 시간측정 종료:" + end);
            long result = (end - start)/1000;
            System.out.println("실행시간(초):" + result);
        }
    }

    private boolean hasStopWatch(){
        for(Method method : performanceTestable.getClass().getDeclaredMethods()){
            StopWatch1 stopWatch = method.getAnnotation(StopWatch1.class);
            if(Objects.nonNull(stopWatch)){
                return true;
            }
        }
        return false;
    }
}