package review.J3.Thread.threadPool.test;

import org.junit.Test;
import review.J3.Thread.threadPool.threadPool.ThreadPool;

public class poolTest {

    /**
     * 测试长度不限的线程池
     */
    @Test
    public void cachedThreadPoolTest(){
        ThreadPool.useCachedThreadPool();
    }

    /**
     * 测试长度固定的线程池
     */
    @Test
    public void fixedThreadPoolTest(){
        ThreadPool.useFixedThreadPool();
    }

    /**
     * 使⽤单个worker线程的Executor
     */
    @Test
    public void singleThreadExecutorTest(){
        ThreadPool.useSingleThreadExecutor();
    }

    /**
     * 使⽤单个worker线程的Executor
     */
    @Test
    public void scheduledThreadExecutorTest(){
        ThreadPool.useScheduledThreadExecutor();
    }
}
