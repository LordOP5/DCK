import java.io.*;

public class Grade {
	public static void main(String[] args) {
		try{	
			int num = Integer.parseInt(args[0]);
			if(num > 100 || num < 0 ){
				throw new IllegalArgumentException();
			}else{
				if(num >= 80 && num <= 100){
					System.out.println("A");
				}else if(num >= 70 && num <= 79){
					System.out.println("B");
				}else if(num >= 60 && num <= 69){
					System.out.println("C");
				}else if(num >= 50 && num <= 59){
					System.out.println("D");
				}else if(num <= 49){
					System.out.println("F");
				}
			}
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Plase enter your score");
		} catch(NumberFormatException ee){
			System.out.println("Plase enter integer number");
		} catch(IllegalArgumentException eee){
			System.out.println("Plase enter number 0-100");
		}		
	}
}