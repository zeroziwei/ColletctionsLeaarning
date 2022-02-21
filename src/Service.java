import java.io.*;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket s = serverSocket.accept();
        InputStream inputStream = s.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String str = dataInputStream.readUTF();
        System.out.printf("客服端发来的数据为："+str);
        OutputStream outputStream = s.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("你好，我是客户端，我收到你的请求了");
        dataOutputStream.close();
        outputStream.close();
        dataInputStream.close();
        inputStream.close();
        s.close();
        serverSocket.close();
    }
}
