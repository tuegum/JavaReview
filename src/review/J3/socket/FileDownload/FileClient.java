package review.J3.socket.FileDownload;

import java.io.*;
import java.net.Socket;

public class FileClient {

    private void connect(){
        try(Socket socket = new Socket("127.0.0.1", 6213);) {
            InputStream is = socket.getInputStream();

            File client_file = new File("D:\\tuegum\\interest\\japanese\\copy_1");
            client_file.mkdirs();
            DataInputStream in = new DataInputStream(is);
            DataOutputStream out = new DataOutputStream(new FileOutputStream(client_file));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileClient().connect();
    }
}
