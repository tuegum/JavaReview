package review.J3.socket.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class StudentClient {

    public void connect(){
        Gson gson = new Gson();
        try(Socket socket = new Socket("10.2.81.54", 7477);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream())) {
            String msg = in.readUTF();
            List<Student> list = gson.fromJson(msg, new TypeToken<List<Student>>() {}.getType());
            for (Student student : list) {
                System.out.println(student);
            }
            out.writeObject(new Student(1,"张三",23));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentClient().connect();
    }
}
