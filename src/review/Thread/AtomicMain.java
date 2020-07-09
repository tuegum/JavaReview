package review.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Count count = new Count();
        for (int i = 0; i < 100; i++) {
            service.execute(() -> count.increase());
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(count.getCount());
    }

    static class Count {
        //原子变量类解决线程安全问题，但是会存在ABA问题
        private AtomicInteger count = new AtomicInteger(0);
        Integer getCount(){
            return count.get();
        }
        void increase(){
            count.incrementAndGet();
        }
    }
}
