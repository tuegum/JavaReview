package review.J3.socket.socketDemo2.deamon.client;

import review.J3.socket.socketDemo2.utils.ReadingTask;
import review.J3.socket.socketDemo2.utils.WritingTask;

import java.io.IOException;
import java.net.Socket;

public class chatClient {

    public void connect(){
        try{
            Socket socket = new Socket("10.2.81.54", 5555);
            new Thread(new ReadingTask(socket.getInputStream())).start();
            new Thread(new WritingTask(socket.getOutputStream())).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new chatClient().connect();
    }
}
