package review.freeStyle.counter;

import java.util.List;

public class test {
    public static void main(String[] args) {
        String s = utils.getString();
        List<Character> list = utils.getStringToChar(s);
        utils.bianliList(list);
        System.out.println("一共" + list.size() + "字符");
    }
}
