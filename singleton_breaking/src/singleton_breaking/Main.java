package singleton_breaking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;



class Abc implements Cloneable,Serializable{
	public static Abc obj;
	private Abc(){
		if(obj!=null) {
			throw new IllegalStateException("cannot re-instantiate a singleton class");
		}
		System.out.println("constructor called");
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		if(obj!=null) {
			throw new CloneNotSupportedException("cannot redifine singleton classes");
		}
		return super.clone();
	}
	protected Object readResolve() {
		return obj;
	}
	public static Abc method() {
		if(obj==null)
		{
			synchronized(Abc.class) {
				if(obj==null)obj=new Abc();
			}
		}

		return obj;
	}
	int i;
	public void show() {
		System.out.println(i);
	}
}
enum Qwe{
INSTANCE;
int i;
public void show() {
	System.out.println("The show is called "+i);
}
}
public class Main {
	public static void main(String[] args) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException {
		Abc original=Abc.method();
//		Abc duplicate=(Abc)original.clone();
//		System.out.println(original.hashCode());
//		System.out.println(duplicate.hashCode());
		
//		Abc reflectionInstance=null;
//		Constructor[] constructors=Abc.class.getDeclaredConstructors();
//		for( Constructor constructor:constructors) {
//			constructor.setAccessible(true);
//			reflectionInstance=(Abc)constructor.newInstance();
//			
//		}
		FileOutputStream fos=new FileOutputStream("C:\\serialization\\codedecode.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(original);
		oos.close();
		fos.close();
		
		FileInputStream fis=new FileInputStream("C:\\serialization\\codedecode.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Abc obj=(Abc) ois.readObject();
		ois.close();
		fis.close();
		System.out.println(original.hashCode());
		System.out.println(obj.hashCode());
		
	}
}
