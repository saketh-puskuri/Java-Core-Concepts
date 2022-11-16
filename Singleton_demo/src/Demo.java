
class abc implements Cloneable{
	public static abc obj;
	private abc(){
		System.out.println("constructor called");
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		if(obj!=null) {
			throw new CloneNotSupportedException("cannot redifine singleton classes");
		}
		return super.clone();
	}
	public static abc method() {
		if(obj==null)
		{
			synchronized(abc.class) {
				if(obj==null)obj=new abc();
			}
		}

		return obj;
	}
	int i;
	public void show() {
		System.out.println(i);
	}
}
//enum Abc{
//	INSTANCE;
//	int i;
//	public void show() {
//		System.out.println("The show is called "+i);
//	}
//}
public class Demo {
	public static void main(String[] args) throws CloneNotSupportedException {
//		Abc obj=Abc.INSTANCE;
//		obj.i=1;
//		obj.show();
//		Abc obj2=Abc.INSTANCE;
//		obj2.i=3;
//		obj.show();
//		Thread t1=new Thread(()->{
//			abc obj=abc.method();
//		});
//		Thread t2=new Thread(()->
//		{
//			abc obj=abc.method();
//		});
//		t1.start();
//		t2.start();
//		abc obj=abc.method();
//		obj.i=1;
//		obj.show();
//		abc obj1=abc.method();
//		obj1.i=2;
//		obj.show();
		abc original=abc.method();
		abc duplicate=(abc)original.clone();
		System.out.println(original.hashCode());
		System.out.println(duplicate.hashCode());
		
		
		
	}
}
