import java.util.InputMismatchException;
import java.util.Scanner;
// Exception is an event that disrupts normal flow of code not handling them leads to a problem
// error vs exception

class MyException extends Exception{
	public MyException(String s){
		super(s);
	}
}
public class Example {
	public static void main(String args[]) throws MyException{
		Scanner sc=new Scanner(System.in);
		int[] arr= {1,2,3,4};
		try {
			System.out.println("Enter 1st number");
			int num1=sc.nextInt();
			System.out.println("Enter 2st number");
			int num2=sc.nextInt();
			if(num1<3 || num2<1) {
				throw new MyException("Num1 cannot be less than 3 and Num2 cannot be less than 1");
			}
			System.out.println((double)num1/num2);
			System.out.println("Enter index");
			int i=sc.nextInt();
			System.out.println(arr[i]);	
			
		}
		catch(MyException e) {
			System.out.println(e.getMessage());
		}
		catch(ArithmeticException e) {
			System.out.println("cannot divide by zero");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Given number not in array limit");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("program terminated");
		}
		
	}
}
