package com.akburkut.tv.cms.akburkut.practice.multithread;

//舞台
public class Stage extends Thread{

    public void run(){
        System.out.println("欢迎观看隋唐演义");

        //让观众们安静片刻，等待大戏上演
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("大幕徐徐拉开");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("话说隋朝末年，隋军与农民起义军杀得昏天黑地...");

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用Runnable接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "随军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

        //启动线程，让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠，观众专心观看演出
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        try {
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("正当双方激战正酣时， 半路杀出了个程咬金！");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("程咬金的理想是结束战争，使百姓安居乐业！");

        //军队停止作战
        //停止线程的方法
        armyTaskOfSuiDynasty.keepRunnig = false;
        armyTaskOfRevolt.keepRunnig = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        * 历史大戏留给关键人物
         */
        mrCheng.start();
        //万众瞩目，所有线程等待程先生完成历史使命
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
        System.out.println("谢谢观看隋唐演义，再见！");
    }


    public static void main(String[] args){
        new Stage().start();
    }
}
