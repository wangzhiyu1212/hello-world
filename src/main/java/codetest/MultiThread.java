package codetest;

public class MultiThread implements Runnable {
	public int count = 100;
	public static int count2 = 100;

	public void run() {
		//System.out.println(Thread.currentThread().getName() + " count1-1:" + count);
		System.out.println(Thread.currentThread().getName() + " count2-1:" + count);
		while (MultiThread.count2 > 0) {
			//synchronized(this) {
			//System.out.println(Thread.currentThread().getName() + " count1-2:" + count);
			System.out.println(Thread.currentThread().getName() + " count2-2:" + count);
			count--;
			count2--;
			//}
		}
	}

	public static void main(String argsp[]) {
		Runnable run = new MultiThread();
		
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
