package review.freeStyle.counter;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class utils {

    public static String getString(){
        System.out.println("please enter a String:");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    static List<Character> getStringToChar(String s){
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            list.add(item);
        }
        return list;
    }

    static void bianliList(List<Character> list){
        for (Character c : list) {
            System.out.println(c);
        }

    }
}
