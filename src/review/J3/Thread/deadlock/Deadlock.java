package review.J3.Thread.deadlock;

public class Deadlock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void fun1(){
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName() + "持有lock1锁，需要lock2锁");
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + "解锁完毕");
            }
        }
    }

    public void fun2(){
        synchronized (lock2){
            System.out.println(Thread.currentThread().getName() + "持有lock2锁，需要lock1锁");
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + "解锁完毕");
            }
        }
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        new Thread(()-> deadlock.fun1()).start();
        new Thread(deadlock::fun2).start();
    }

}
