package review.J3.socket.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;

public class StudentServer {

    public void start(){
        System.out.println("服务器启动了！");
        try(ServerSocket serverSocket = new ServerSocket(7777);) {
            for(;;){
                ObjectInputStream in = new ObjectInputStream(serverSocket.accept().getInputStream());
                Student stu = (Student)in.readObject();
                System.out.println("接受对象：" + stu);
            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentServer().start();
    }
}
