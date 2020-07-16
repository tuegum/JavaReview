package review.J3.socket.FileDownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class FileServer {

    public void start(){
        try(ServerSocket serverSocket = new ServerSocket(6213);) {


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileServer().start();
    }
}
