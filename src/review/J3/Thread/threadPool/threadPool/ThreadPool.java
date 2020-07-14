package review.J3.Thread.threadPool.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "启动了！");
        }
    }

    public static void useCachedThreadPool(){
        //创建长度不限的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            //开启线程
            pool.execute(new MyRunnable());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //关闭线程池
        pool.shutdown();
    }

    public static void useFixedThreadPool(){
        //创建长度不限的线程池
        ExecutorService pool = Executors.newFixedThreadPool(17);
        for (int i = 0; i < 10; i++) {
            //开启线程
            pool.execute(new MyRunnable());
        }
        //关闭线程池
        pool.shutdown();
    }

    //使⽤单个worker线程的Executor
    public static void useSingleThreadExecutor(){
        //创建长度不限的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            //开启线程
            pool.execute(new MyRunnable());
        }
        //关闭线程池
        pool.shutdown();
    }


    public static void useScheduledThreadExecutor(){
        //创建线程池
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(17);
        //可以控制线程的执行时间和周期
        pool.scheduleAtFixedRate(new MyRunnable(),1,5, TimeUnit.SECONDS);
        //关闭线程池
        //pool.shutdown();
    }

    public static void main(String[] args) {
        useScheduledThreadExecutor();
    }
}
