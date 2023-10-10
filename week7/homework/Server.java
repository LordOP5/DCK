import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server implements Runnable {
    Socket s = null;
    volatile static HashMap<String,String> map = new HashMap<String,String>();

    public Server(Socket s) {
        this.s = s;
    }

    public void run() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());

            String command = br.readLine();
            String studentid = br.readLine();
            String studentname = br.readLine();

            if (command.equals("add")) {
                String id = studentid;
                String name = studentname;
                map.put(id, name);
                pw.println("Result = OK");
            } else if (command.equals("search")) {
                String id = studentid;
                String all = map.get(id);
                if (all != null) {
                    pw.println("Result = " + all);
                } else {
                    pw.println("Result = N/A");
                }
            } else {
                pw.println("Result = Command not found");
            }

            pw.flush();
            pw.close();
            br.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocket ss = null;
        ExecutorService es = Executors.newFixedThreadPool(15);

        try {
            ss = new ServerSocket(23410);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket s = ss.accept();
                Server sv = new Server(s);
                es.execute(sv);
            } catch (Exception e) {}
        }
    }
}