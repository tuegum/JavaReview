package review.J3.socket.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class StudentClient1 {

    private void connect(){

        List<Student> list1 = utils.getList();
        Gson gson = new Gson();
        String json = gson.toJson(list1);

        try(Socket socket = new Socket("10.2.81.54", 7477);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {

            //接受服务端发送的json数据
            List<Student> stu = gson.fromJson((new DataInputStream(socket.getInputStream())).readUTF(), new TypeToken<List<Student>>() {}.getType());
            utils.bianli(stu);

            //发送Json数据
//            new DataOutputStream(socket.getOutputStream()).writeUTF(json);

            //发送object数据
            out.writeObject(new Student(1,"张三",23));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentClient1().connect();
    }
}
