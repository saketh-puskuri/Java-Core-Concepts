package seralization.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Employee e=new Employee();
		e.setId(1);
		e.setName("saketh");
		FileOutputStream fos=new FileOutputStream("C:\\serialization\\codedecodeFile.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(e);
		oos.close();
		fos.close();
		
		FileInputStream fis=new FileInputStream("C:\\serialization\\codedecodeFile.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Employee obj=(Employee) ois.readObject();
		System.out.println(obj.getId()+" "+obj.getName());
		fis.close();
		ois.close();
	}
}
