import java.util.Scanner;
// Abstraction: This is the process of hiding internal details from the world
//Ex:App in a Playstore

interface A{
	public int i=1;
	void show();
	void details();
}
//abstract class A{
//	abstract void show();
//	abstract void details();
//}
class B implements A{

	public void show() {
		System.out.println("show");
		
	}
	public void details() {
		System.out.println(i);
	}


	
}
public class AbstractionEx {
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		int num1=sc.nextInt();
//		int num2=sc.nextInt();
//		System.out.println(num1+num2);
		B b=new B();
		b.show();
		b.details();
	}
}
