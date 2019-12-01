package concurrent;

import java.util.concurrent.Callable;

/**
 * @Classname Concurr_01_ThreadTest
 * @Description 实现线程的几种方式
 * @Date 11/15/2019 4:28 PM
 * @Created by MichaelCS
 */
public class Concurr_01_ThreadTest {

    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("This is MyThread");
        }
    }


    private static class MyRunable implements Runnable{
        @Override
        public void run() {
            System.out.println("I am Runnable");
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyCallable implements Callable{
        /**
         * @return
         * @throws Exception
         */
        @Override
        public String call() throws Exception {
            return "Im Callable";
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 实例化Thread
        MyThread myThread = new MyThread();

        myThread.start();
        // todo 为何异常？
//        myThread.wait();

        MyRunable runable = new MyRunable();
        new Thread(runable).start();


        System.out.println(Thread.currentThread().getName());


    }
}
