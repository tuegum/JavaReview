package review.J3.socket.socketDemo2.deamon.server;

import review.J3.socket.socketDemo2.utils.ReadingTask;
import review.J3.socket.socketDemo2.utils.WritingTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class chatServer {

    public void start(){
        System.out.println("服务端启动！");
        try(ServerSocket serverSocket = new ServerSocket(5555);) {
            for (;;){
                Socket socket = serverSocket.accept();
                new Thread(new ReadingTask(socket.getInputStream())).start();
                new Thread(new WritingTask(socket.getOutputStream())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new chatServer().start();
    }
}
