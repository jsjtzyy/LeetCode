/* Example of Java Socket Programming (Client)
*/
package Communication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
  public static void main(String[] args) {
    try {
      Socket s = new Socket("127.0.0.1", 8888);
      Scanner scanner = new Scanner(System.in);
      //构建IO
      InputStream is = s.getInputStream();
      OutputStream os = s.getOutputStream();

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      System.out.println("start client completed.");
      boolean running = true;
      String cmd;
      while (running) {
        cmd = scanner.nextLine();
        if (cmd.equals("stop")) {
          running = false;
          System.out.println("shutting down the client and server");
          bw.write(cmd + "\n");
          bw.flush();
        } else {
          //向服务器端发送一条消息
          bw.write(cmd + "\n");           // never miss the "\n" as a sign of end of line
          bw.flush();
          //读取服务器返回的消息
          String mess = br.readLine();
          System.out.println("服务器：" + mess);
        }
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
