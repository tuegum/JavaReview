package review.J3.socket.socketDemo1.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
    private ServerSocket serverSocket;
    private Socket socket;
    private void start(){
        System.out.println("服务器启动了");
        try {
            serverSocket = new ServerSocket(8888);
            for (;;){
                socket = serverSocket.accept();
                System.out.println(socket.getLocalSocketAddress() + "   ||  " + socket.getInetAddress() + "连接了");
                InputStream is = socket.getInputStream();
                byte[] bytes = new byte[1024 * 10];
                int len = is.read(bytes);
                System.out.println(new String(bytes,0,len));
                OutputStream os = socket.getOutputStream();
                os.write("你好，我是服务端".getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Myserver().start();
    }
}
