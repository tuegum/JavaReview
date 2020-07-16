package review.J3.socket.dataJson.socket;

import com.google.gson.Gson;
import review.J3.socket.dataJson.dao.GoodsDao;
import review.J3.socket.dataJson.domain.Goods;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class DataServer {

    public void start(){
        System.out.println("服务端开启!");
        List<Goods> list = new GoodsDao().findAll();
        Gson gson = new Gson();
        String json = gson.toJson(list);

        try(ServerSocket serverSocket = new ServerSocket(6666);) {
            for (;;){
                Socket socket = serverSocket.accept();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("发送数据：" + json);
                out.writeUTF(json);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DataServer().start();
    }
}
