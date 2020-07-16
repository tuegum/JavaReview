package review.J3.socket.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用Json包装数据进行网络数据传输，效率高
 */
public class StudentServer {

    public void start(){
        System.out.println("服务器启动了！");

        List<Student> list = utils.getList();
        Gson gson = new Gson();
        String json = gson.toJson(list);

        try(ServerSocket serverSocket = new ServerSocket(7477);
           ) {
            for(;;){
                //发送json数据给客户端
                Socket socket = serverSocket.accept();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("服务器发送：" + json);
                out.writeUTF(json);

                //接收客户端Object数据
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Student stu = (Student)in.readObject();
                System.out.println("接受对象：" + stu);

                //接受客户端发来的json数据
/*                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String msg = dis.readUTF();
                List<Student> stu2 = gson.fromJson(msg,new TypeToken<List<Student>>() {}.getType());
                utils.bianli(stu2);*/
//                List<Student> stu1 = gson.fromJson((new DataInputStream(socket.getInputStream())).readUTF(), new TypeToken<List<Student>>() {}.getType());
//                utils.bianli(stu1);
            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentServer().start();
    }
}
