package review.J3.Thread.singleton.test;

import org.junit.Test;
import review.J3.Thread.singleton.hungry.MySingleton;
import review.J3.Thread.singleton.lazy.MyLazySingleton;

import java.io.IOException;

/**
 * 单例模式单元测试
 */
public class test {

    /**
     * 1.单例模式创建的对象是同一个
     */
    @Test
    public void SingletonObjectTest(){
        MySingleton s1 = MySingleton.getInstance();
        MySingleton s2 = MySingleton.getInstance();
        MySingleton s3 = MySingleton.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
    }

    /**
     * 2.饿汉式单例模式，调用其他普通静态方法会创建实例
     */
    @Test
    public void SingletonTest(){
//        MyLazySingleton.getInstance();
        MySingleton.fun();
    }

    /**
     * 3.饿汉式单例模式---example---Runtime
     */
    @Test
    public void RuntimeTest(){
                //运行时（单例模式）
        Runtime runtime = Runtime.getRuntime();
        System.out.println("cpu: " + runtime.availableProcessors());

        try {
            runtime.exec("mspaint");//运行时调用cmd命令打开画图
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4.懒汉式单例模式，调用其他普通静态方法不会创建实例
     */
    @Test
    public void lazySingletonTest(){
        System.out.println(MyLazySingleton.getInstance().hashCode());
//        MyLazySingleton.fun();
    }

    /**
     *  5.懒汉式单例模式，多线程情况可能出现异常
     *  多个线程可能同时读取到这一行 "myLazySingleton == null",一开始都为空，全都创建新的对象
     *  使用同步代码块解决线程安全问题
     */
    @Test
    public void lazySingletonObjectTest(){
        for (int i = 0; i < 200; i++) {
            new Thread(()-> System.out.println(MyLazySingleton.getInstance().hashCode())).start();
        }
    }

}
