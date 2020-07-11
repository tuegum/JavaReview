package review.J3.Thread.singleton.lazy;

/**
 * 懒汉式单例模式，一开始（类加载时）不创建对象
 * 在静态方法中创建对象
 */
public class MyLazySingleton {
    //1.定义静态对象
    private static MyLazySingleton myLazySingleton = null;

    //2.将构造方法设置为private
    private MyLazySingleton(){
        System.out.println("单例模式，懒汉式，一开始（类加载时）不创建对象，在静态方法中创建对象");
    }

    //3.静态方法返回对象
    public static MyLazySingleton getInstance(){
        //外层判断，如果对象不为空，则不走锁机制，提高系统性能
        if (myLazySingleton == null){
            //同步代码块解决线程安全问题
            synchronized(MyLazySingleton.class){
                if (myLazySingleton == null){
                    myLazySingleton = new MyLazySingleton();
                }
            }
        }
        return myLazySingleton;
//        return  ? new MyLazySingleton() : myLazySingleton;
    }

    public static void fun(){
        System.out.println("我是一个普通的静态方法");
    }
}
