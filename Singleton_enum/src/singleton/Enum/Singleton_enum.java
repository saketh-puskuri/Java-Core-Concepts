package singleton.Enum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

enum Singleton{
	INSTANCE;
	int i;
	public void show() {
		System.out.println("The value of i is "+i);
	}
}
public class Singleton_enum {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Singleton obj=Singleton.INSTANCE;
		Class c=Class.forName("singleton.Enum.Singleton");
		obj.i=1;
		obj.show();
		FileOutputStream fos=new FileOutputStream("C:\\serialization\\singleton_enum.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
		fos.close();
		FileInputStream fis=new FileInputStream("C:\\serialization\\singleton_enum.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Singleton obj1=(Singleton)ois.readObject();
		obj1.show();
		obj1.i=2;
		obj.show();
		obj1.show();
		System.out.println(obj1.hashCode());
		System.out.println(obj.hashCode());
	}
}
