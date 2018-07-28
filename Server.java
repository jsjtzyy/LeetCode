/* Example of Java Socket Programming (Server).
*/
package Communication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
  public static void main(String[] args) {
    boolean running = true;
    try {
      ServerSocket ss = new ServerSocket(8888);
      System.out.println("启动服务器....");
      Socket s = ss.accept();
      System.out.println("客户端:" + InetAddress.getLocalHost() + "已连接到服务器");

      BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
      while (running) {
        if(!s.isConnected()){
          System.out.println("lose connection!!");
          break;
        }
        //读取客户端发送来的消息
        String mess = br.readLine();
        if(mess == null){
          System.out.println("the message is null!");
          break;
        }
        System.out.println("received: " + mess);
        if (mess.equals("exit")) {
          System.out.println("Shutting down server");
          running = false;
        } else {
          System.out.println("客户端：" + mess);
          bw.write(mess + "\n");
          bw.flush();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
