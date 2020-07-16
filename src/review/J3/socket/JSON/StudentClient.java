package review.J3.socket.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class StudentClient {

    private void connect(){
        List<Student> list1 = utils.getList();
        Gson gson = new Gson();
        String json = gson.toJson(list1);
        try(Socket socket = new Socket("10.2.81.54", 7477);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out1 = new DataOutputStream(socket.getOutputStream())) {
            for (;;){
                String msg = in.readUTF();
                out1.writeUTF(json);
                List<Student> list = gson.fromJson(msg, new TypeToken<List<Student>>() {}.getType());
                utils.bianli(list);

                out.writeObject(new Student(1,"张三",23));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentClient().connect();
    }
}
