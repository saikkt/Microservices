package org.example;

public class Main
{
    public static void main(String[] args) {
        ExtendingThread t1 = new ExtendingThread();
        Thread t2 = new Thread(new ImplementingRunnable());
      //  t1.setDaemon(true);
      //  t2.setDaemon(true);
        t1.start();
        t2.start();
        try {
            Thread.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Thread: [%s] End of main",Thread.currentThread().getName()));
    }
}

class ExtendingThread extends Thread
{
    @Override
    public void run()
    {
        for(int i=0;i < 10;i++)
        {
            System.out.println(String.format("Thread: [%s] value: %d", Thread.currentThread().getName(),i));
        }
    }
}


class ImplementingRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=0;i < 10;i++)
        {
            System.out.println(String.format("Thread: [%s] value: %d", Thread.currentThread().getName(),i));
        }
    }
}