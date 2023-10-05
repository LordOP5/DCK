import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class FileServer implements Runnable {
    Socket s = null;

    public FileServer(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            PrintWriter pw = new PrintWriter(out);

            String command = br.readLine();
            if (command.equals("list")) {
                File f = new File("./");
                String[] filenames = f.list();
                for (String filename : filenames) {
                    pw.println(filename);
                }
            } else if (command.equals("upload")) {
                String fileup = br.readLine();
                File ff = new File(fileup);
                if (!ff.exists()) {
                    pw.println("NOK");
                    pw.flush();
                } else {
                    pw.println("OK");
                    pw.flush();
                    FileOutputStream fout = new FileOutputStream(ff);
                    byte[] buffer = new byte[65536];
                    int size;
                    while ((size = in.read(buffer)) != -1) {
                        fout.write(buffer, 0, size);
                    }
                    fout.close();
                }
            } else if (command.equals("download")) {
                String filedown = br.readLine();
                File fff = new File(filedown);
                if (!fff.exists()) {
                    pw.println("NOK");
                    pw.flush();
                } else {
                    pw.println("OK");
                    pw.flush();
                    FileInputStream fin = new FileInputStream(fff);
                    byte[] bufferr = new byte[65536];
                    int sizes;
                    while ((sizes = fin.read(bufferr)) != -1) {
                        out.write(bufferr, 0, sizes);
                    }
                    out.flush();
                    fin.close();
                }
            } else {
                pw.println("Command not found");
            }
            pw.flush();
            in.close();
            out.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocket ss = null;
        ExecutorService es = Executors.newFixedThreadPool(10);

        try {
            ss = new ServerSocket(6789);
            while (true) {
                Socket s = ss.accept();
                FileServer fs = new FileServer(s);
                es.execute(fs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}