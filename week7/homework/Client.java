import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Client <command> <student_id> [student_name]");
            return;
        }

        if (args.length < 1 || args.length > 3) {
            System.out.println("Usage: java Client <command> <student_id> [student_name]");
            return;
        }

        String command = args[0];
        String studentId = null;
        String studentName = null;

        if (args.length >= 2) {
            studentId = args[1];
        }

        if (command.equals("add") && args.length == 3) {
            studentName = args[2];
        }

        if (!command.equals("add") && !command.equals("search")) {
            System.out.println("Result = Command not found");
            return;
        }

            try {
                Socket s = new Socket("127.0.0.1", 23410);
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream());

                pw.println(command);  
                pw.println(studentId);
                pw.println(studentName);   
                pw.flush();

                String msg = br.readLine();
                System.out.println(msg);
                pw.close();
                br.close();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
