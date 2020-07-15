package review.J3.socket.JSON;

import com.google.gson.Gson;

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
        List<Student> list = new ArrayList<>();
        list.add(new Student(001,"老王",24));
        list.add(new Student(002,"老胡",23));
        list.add(new Student(003,"老万",23));
        list.add(new Student(004,"老刘",25));

        Gson gson = new Gson();
        String json = gson.toJson(list);

        try(ServerSocket serverSocket = new ServerSocket(7477);) {
            for(;;){
                Socket socket = serverSocket.accept();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(json);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentServer().start();
    }
}
