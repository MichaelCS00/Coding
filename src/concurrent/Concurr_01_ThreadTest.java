package concurrent;

/**
 * @Classname Concurr_01_ThreadTest
 * @Description 通过继承 Thread 实现线程
 * @Date 11/15/2019 4:28 PM
 * @Created by MichaelCS
 */
public class Concurr_01_ThreadTest {

    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am child thread");
        }
    }

    public static void main(String[] args){
        MyThread thread = new MyThread();
        System.out.println(Thread.currentThread().getName());
        thread.start();
        try{
            thread.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
