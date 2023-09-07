import java.io.*;

public class TestArgs {
	public static void main(String[] args) {
		try{
			float num1 = Float.parseFloat(args[0]);
			float num2 = Float.parseFloat(args[1]);
			System.out.println(num1 + "x" + num2 + "=" + (num1 * num2));
		} catch(Exception e){
			System.out.println("Usage : java TestArgs <number1> <number2>");
		}
		
	}
}