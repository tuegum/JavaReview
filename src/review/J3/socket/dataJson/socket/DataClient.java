package review.J3.socket.dataJson.socket;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import review.J3.socket.dataJson.domain.Goods;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class DataClient {

    public void connect(){
        Gson gson = new Gson();
        try(Socket socket = new Socket("127.0.0.1", 6666);) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String msg = in.readUTF();
            List<Goods> list = gson.fromJson(msg,new TypeToken<List<Goods>>(){}.getType());
            for (Goods goods : list) {
                System.out.println("接收数据：" + goods);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DataClient().connect();
    }
}
