package com.akburkut.tv.cms.akburkut.practice.DaemonThread;

import java.io.*;
import java.util.Scanner;

public class DaemonThread {

    public static void main(String[] args){
        System.out.println("进入主线程： "+ Thread.currentThread().getName());

        DaemonRunnable dr = new DaemonRunnable();
        Thread thread = new Thread(dr, "演员");
        thread.setDaemon(true);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("退出主线程： "+ Thread.currentThread().getName());
    }
}

class DaemonRunnable implements Runnable{

    @Override
    public void run(){
        System.out.println("进入线程： " + Thread.currentThread().getName());
        writeToFile();
        System.out.println("退出守护线程： " + Thread.currentThread().getName());
    }

    private void writeToFile(){
        try {
            File file = new File("d:" + File.separator + "daemon.txt");
            OutputStream os = new FileOutputStream(file, true);
            int count = 0;
            while (count < 99){
                os.write(("\r\nword" + count).getBytes());
                System.out.println("守护线程： " + Thread.currentThread().getName()
                        + "向文件中写入了word" + count++);
                Thread.sleep(1000);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}