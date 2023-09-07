import java.io.*;

public class JavaBinaryCopy{
    public static void main(String[] args){
        if(args.length != 2) {
			        System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
			        System.exit(1);
        }

        try {          
                File x = new File(args[0]);
                File y = new File(args[1]);
                FileInputStream fin = new FileInputStream(x);
                FileOutputStream fout = new FileOutputStream(y);
                int n;
                byte[] a = new byte[1024];
                while((n = fin.read(a)) != -1){
                    fout.write(a, 0, n);
                    String data = new String(a);
                    System.out.println(data);
                }
                fin.close();
                fout.close();
		} catch(Exception e) {
            System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
			System.exit(1);
        }
    }
}