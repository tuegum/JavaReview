package review.J3.socket.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClient {

    public void connect(){
        try(Socket socket = new Socket("10.2.81.54", 7777);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            out.writeObject(new Student(1,"张三",23));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentClient().connect();
    }
}
