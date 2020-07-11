package review.J3.Thread.singleton.hungry;

/**
 * 饿汉式单例模式，一开始（类加载时）就创建对象，
 */
public class MySingleton {

    //1.定义静态对象
    private static MySingleton mySingleton = new MySingleton();

    //2.构造方法定义为私有
    private MySingleton(){
        System.out.println("单例模式，第一种，饿汉式，类加载时创建了一个对象");
    }

    //3.定义静态方法返回对象
    public static MySingleton getInstance(){
        return mySingleton;
    }

    //p普通静态方法
    public static void fun(){
        System.out.println("我是一个普通的静态方法");
    }
}
