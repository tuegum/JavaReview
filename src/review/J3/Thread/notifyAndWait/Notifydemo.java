package review.J3.Thread.notifyAndWait;

public class Notifydemo {
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                if (i == 30) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("等待3秒后唤醒上一个线程");
                Thread.sleep(3000);
                System.out.println("等待结束");
                synchronized (lock) {
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
