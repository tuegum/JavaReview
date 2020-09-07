package review.freeStyle;

import java.util.Scanner;

public class test {
    private static int Model,Phone;
    public static void main(String[] args) {
        fun();
    }

    private static void bt_vol() {
        System.out.println("请输入Phone音量：");
        Scanner sc = new Scanner(System.in);
        Phone = sc.nextInt();
        Model = 0;
//        Model = Phone < 0 ? 0 : (Phone < 101 ? Phone : ((Phone < 128 ? 10*(Phone - 101)/26 + 100 : 110)));
        if (Phone < 0){

        }else if(Phone <= 100){
            Model = (100 * Phone)/100;
        }else if (Phone < 128){
            Model = ((110 - 100) * (Phone - 101)/(127-101)) + 100;
        }else{
            Model = 110;
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("Phone = " + Phone);
        System.out.println("Model = " + Model);
    }

    public static void fun(){
        for (int i = 0; i < 10; i++) {
            new Thread(()-> bt_vol()).start();
        }
    }
}
