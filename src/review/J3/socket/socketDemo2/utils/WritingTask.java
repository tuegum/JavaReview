package review.J3.socket.socketDemo2.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class WritingTask implements Runnable{
    private OutputStream os = null;

    public WritingTask(OutputStream os) {
        this.os = os;
    }

    @Override
    public void run() {
        try(DataOutputStream out = new DataOutputStream(os);
            Scanner sc = new Scanner(System.in)) {
            for (;;){
                System.out.println("输入消息：");
                String msg = sc.next();
                out.writeUTF(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
