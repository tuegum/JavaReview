package review.J3.socket.socketDemo1.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MyClient {
    private Socket socket;
    private void connect(){
        try {
            socket = new Socket("10.2.81.54", 8888);
//            OutputStream ops = socket.getOutputStream();
            DataOutputStream ops = new DataOutputStream(socket.getOutputStream());
            ops.write("你好，我是客户端".getBytes());
            ops.writeUTF("使用DataOutputStream包装OutputStream,可使用更多方法，方便！");
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024 * 10];
            int len = is.read(bytes);
            System.out.println(new String(bytes,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyClient().connect();
    }
}
