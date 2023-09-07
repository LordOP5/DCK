import java.io.*;

public class JavaThread extends Thread {

    public int number;

    public JavaThread(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        if(args.length != 1) {
			        System.out.println("Please enter 1 number");
			        System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        JavaThread[] num1 = new JavaThread[num];

        for(int i = 0; i < num1.length; i++) {
            num1[i] = new JavaThread(i);
            num1[i].start();
        }

    }

    public void run() {
        System.out.println(number + " Hello World");   
    }
}