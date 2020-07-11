package review.J3.Thread.ConsumerAndProducer;

import org.junit.Test;

public class baoziTest {

 /*   @Test
    public void baozi_test(){
        baozipu bzp = new baozipu();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bzp.makebaozi();
            }
        });
        t1.setName("老板");
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                bzp.takebaozi();
            }
        });
        t2.setName("顾客");
        t2.start();
    }*/

    public static void main(String[] args) {
        baozipu bzp = new baozipu();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bzp.makebaozi();
            }
        });
        t1.setName("老板");
        t1.start();
        for (int i = 0; i < 10; i++) {
            Thread t2 = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    bzp.takebaozi();
                }
            });
            t2.setName("顾客" + i);
            t2.start();
        }

    }
}
