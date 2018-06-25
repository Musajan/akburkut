package com.akburkut.tv.cms.akburkut.practice.thread;


public class TicketsThread {

    public static void main(String[] args){
        //创建三个线程，模拟三个窗口卖票
        MyTread m1 = new MyTread("窗口1");
        MyTread m2 = new MyTread("窗口2");
        MyTread m3 = new MyTread("窗口3");

        //启动三个线程，也即是窗口，开始卖票
        m1.start();
        m2.start();
        m3.start();
    }
}

class MyTread extends Thread{

    private int tickedsCount = 5;//一共五张票
    private String name;//窗口，也即是线程的名字

    public MyTread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        while (tickedsCount > 0){
            tickedsCount--;//如果还有票，就卖掉一张
            System.out.println(name + "卖了1张票，剩余票数为： " + tickedsCount);
        }
    }
}
