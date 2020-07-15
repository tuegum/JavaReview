package review.J3.socket.socketDemo2.test;

import java.io.*;
import java.util.Scanner;

public class utils {
    public static void readThread(InputStream is){
        new Thread(()->{
            try(DataInputStream in = new DataInputStream(is);) {
                for (;;){
                    String msg = in.readUTF();
                    System.out.println("对方说：" + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void writeThread(OutputStream os){
        new Thread(()->{
            try(DataOutputStream out = new DataOutputStream(os);
                Scanner sc = new Scanner(System.in);) {
                for (;;){
                    System.out.println("输入消息：");
                    String msg = sc.next();
                    out.writeUTF(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
