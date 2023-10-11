import java.net.*;
import java.io.*;

public class Server2 {
    public static void main(String[] args) {
        ServerSocket servSocket = null;
        try {
            servSocket = new ServerSocket(20000);
        } catch (Exception e) { e.printStackTrace(); }

        while(true) {
            try {
                Socket s = servSocket.accept();

                BufferedReader br = new BufferedReader(
                                    new InputStreamReader(
                                    s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                String login = br.readLine();
                String passwd = br.readLine();

                if(login.equals("admin") && passwd.equals("admin")) {
                    pw.println("OK");
                } else {
                    pw.println("NO");
                }
                pw.flush();
                br.close();
                pw.close();
                s.close();
            } catch (Exception e) {}
        }
    }
}
