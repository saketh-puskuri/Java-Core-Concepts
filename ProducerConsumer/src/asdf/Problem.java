package asdf;
class Company{
	int n;
	boolean flag=false;
	synchronized public void produce_item(int n) throws InterruptedException {
		if(flag==true) {
			wait();
		}
		this.n=n;
		System.out.println("Produced :"+this.n);
		this.flag=true;
		notify();
	}
	synchronized public void consume_item(int n) throws InterruptedException {
		if(flag==false) {
			wait();
		}
		this.n=n;
		System.out.println("Consumed :"+this.n);
		this.flag=false;
		notify();
	}
}
class Producer extends Thread{
	Company c;
	Producer(Company c){
		this.c=c;
	}
	public void run() {
		int i=1;
		while(i<15) {
			try {
				this.c.produce_item(i);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
}
class Consumer extends Thread{
	Company c;
	Consumer(Company c){
		this.c=c;
	}
	public void run() {
		int i=1;
		while(i<15) {
			try {
				this.c.consume_item(i);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}
public class Problem {
	public static void main(String args[]) {
		Company com=new Company();
		Producer p=new Producer(com);
		Consumer c=new Consumer(com);
		p.start();
		c.start();
	}
}
