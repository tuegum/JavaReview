package review.J3.socket.JSON;

import java.util.ArrayList;
import java.util.List;

public class utils {
    public static List<Student> getList(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(001,"老王",24));
        list.add(new Student(002,"老胡",23));
        list.add(new Student(003,"老万",23));
        list.add(new Student(004,"老刘",25));
        return list;
    }
    public static void bianli(List<Student> list){
        for (Student stu : list) {
            System.out.println( "接收对象：" + stu);
        }
    }
}
