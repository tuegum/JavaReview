package review.J3.socket.socketDemo2.test;

import java.io.IOException;
import java.net.Socket;

public class TcpClient {

    private void connect(){
        try {
            Socket socket = new Socket("127.0.0.1", 5678);
            utils.readThread(socket.getInputStream());
            utils.writeThread(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TcpClient().connect();
    }
}
