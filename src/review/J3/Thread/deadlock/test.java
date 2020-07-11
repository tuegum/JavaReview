package review.J3.Thread.deadlock;

import org.junit.Test;

/**
 * 死锁单元测试
 */
public class test {
    @Test
    public void DeadlockTest(){
        Deadlock deadlock = new Deadlock();
        for (int i = 0; i < 100; i++) {
            new Thread(()-> deadlock.fun1()).start();
            new Thread(deadlock::fun2).start();
        }
    }
}
