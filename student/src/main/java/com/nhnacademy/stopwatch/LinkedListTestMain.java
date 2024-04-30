package com.nhnacademy.stopwatch;

public class LinkedListTestMain {
    public static void main(String[] args) {
        PerformanceTestable performanceTestable=new LinkedListTest();
        LinkedListTestProxy linkedListTestProxy = new LinkedListTestProxy(performanceTestable);
        linkedListTestProxy.test();
    }
}