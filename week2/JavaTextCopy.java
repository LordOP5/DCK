import java.io.*;

public class JavaTextCopy{
    public static void main(String[] args){
        if(args.length != 2) {
			        System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
			        System.exit(1);
        }

        try {
                String msg;
                File x = new File(args[0]);
                File y = new File(args[1]);
                FileInputStream fin = new FileInputStream(x);
                FileOutputStream fout = new FileOutputStream(y);
                InputStreamReader ir = new InputStreamReader(fin);
                BufferedReader br = new BufferedReader(ir);
                PrintWriter pout = new PrintWriter(fout);
                while((msg = br.readLine()) != null){
                    pout.print(msg);
                    pout.flush();
                    System.out.println(msg);
                }
                fin.close();
                fout.close();     
        } catch(Exception e){
            System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
			System.exit(1);
        }   
    }
}