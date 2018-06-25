package com.akburkut.tv.cms.akburkut.practice.runnable;

public class TicketsRunnable {

    public static void main(String[] args){
        MyRunnable m = new MyRunnable();
        //创建三个线程模拟三个售票窗口
        Thread thread1 = new Thread(m, "窗口1");
        Thread thread2 = new Thread(m, "窗口2");
        Thread thread3 = new Thread(m, "窗口3");

        //启动这三个线程，也即是三个窗口，开始卖票
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnable implements Runnable{

    private int ticketsCount = 10;//一共有5张火车票

    @Override
    public void run(){
        while (ticketsCount > 0){
            ticketsCount--;
            System.out.println(Thread.currentThread().getName() + "卖了1张票，剩余票数为： " + ticketsCount);
        }
    }
}
