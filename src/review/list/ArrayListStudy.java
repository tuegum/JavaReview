package review.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList底层实现是数组，非线程安全
 */
public class ArrayListStudy {
    public static void main(String[] args) {

        ArrayListMethod00();
        ArrayListMethod01();
    }

    private static void ArrayListMethod00() {
        //ArrayList快速回顾
        List list = new ArrayList(3);
        list.add(1);
        list.add(2.22);
        list.add("333");
        list.add(list);
        list.add(2,"你好");
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("=============");
        Object set = list.set(0, "我不知道");
        System.out.println(set);
        System.out.println("===========");
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private static void ArrayListMethod01() {
        //ArrayList实现同步
        List list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
    }
}
