package review.J3.socket.socketDemo2.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private void start(){
        System.out.println("服务端启动了！");
        try(ServerSocket serverSocket = new ServerSocket(5678);) {
            Socket socket = serverSocket.accept();
            utils.readThread(socket.getInputStream());
            utils.writeThread(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TcpServer().start();
    }
}
