package review.J3.socket.socketDemo2.utils;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadingTask implements Runnable{

    private InputStream is = null;

    public ReadingTask(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try(DataInputStream in = new DataInputStream(is)) {
            for (;;){
                String msg = in.readUTF();
                System.out.println("对方说：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
