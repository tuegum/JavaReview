package review.J3.Thread.ConsumerAndProducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueBaiziTest {
    public static void main(String[] args) {
        BlockingQueue<baozi> bzs = new ArrayBlockingQueue<>(100);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    baozi bz = new baozi(bzs.size());
                    System.out.println(Thread.currentThread().getName() + "做了" + bz);
                    bzs.put(bz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("老板");
        t1.start();

        for (int i = 0; i < 10; i++) {
            Thread t2 = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        baozi bz = bzs.take();
                        System.out.println(Thread.currentThread().getName() + "吃了" + bz);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t2.setName("顾客" + i);
            t2.start();
        }
    }
}
