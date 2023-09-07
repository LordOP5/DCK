import java.io.*;

public class Ex01 {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Please enter 2 arguments");
			System.exit(1);
		}
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		System.out.println("Result = " + (num1 + num2));
	}
}