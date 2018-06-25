package com.akburkut.tv.cms.akburkut.practice.multithread;

public class KeyPersonThread extends Thread{

    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始战斗了！");
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName()+"左突右杀，攻击随军");
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
