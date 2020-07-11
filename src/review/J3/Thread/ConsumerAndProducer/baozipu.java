package review.J3.Thread.ConsumerAndProducer;

import java.util.ArrayList;
import java.util.List;

public class baozipu {
    public static final int MAX = 100;
    private static List<baozi> baoziList = new ArrayList<>();

    public synchronized void makebaozi(){
        if (baoziList.size() == MAX){
            System.out.println("包子库存已满，" +Thread.currentThread().getName() +"等待...");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (baoziList.size() < MAX){
            baozi bz = new baozi(baoziList.size());
            System.out.println(Thread.currentThread().getName() + "创建了" + bz);
            baoziList.add(bz);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (baoziList.size() > 0){
            this.notifyAll();
        }
    }

    public synchronized void takebaozi(){
        if (baoziList.size() == 0){
            System.out.println("包子库存空了" + Thread.currentThread().getName() + "等待...");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            this.notifyAll();
        }
        if (baoziList.size() > 0){
            baozi bz = baoziList.remove(baoziList.size() - 1);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "吃掉了" + bz);
        }
    }
}
