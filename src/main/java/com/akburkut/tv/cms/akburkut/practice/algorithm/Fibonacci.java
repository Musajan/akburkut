package com.akburkut.tv.cms.akburkut.practice.algorithm;

import java.util.Calendar;

public class Fibonacci {

    public static void main(String[] args){

        long begin = getCost();
        System.out.println("递推方式实现： "+Fibonacci(10));
        //System.out.println("递归方式实现 ： "+FibonacciIns(50));
        long end = getCost();
        long cost = end - begin;
        System.out.println("总消耗时间： "+cost);
    }

    //递推方式
    public static long Fibonacci(int num){
        if (num <= 2){
            return 1;
        }
        long fibo1 = 1;
        long fibo2 = 1;
        long sum = 0;
        for (int i = 0; i < num - 2; i++){
            System.out.println("fibo1= "+fibo1 + " *** fibo2="+fibo2);
            System.out.println("执行了："+i);
            sum = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = sum;
        }
        return sum;
    }

    //递归方式实现
    public static long FibonacciIns(int num){
        if (num <= 2){
            return 1;
        }else {
            return FibonacciIns(num - 1) + FibonacciIns(num - 2);
        }
    }

    //获取当前时间戳
    public static long getCost(){
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }
}
