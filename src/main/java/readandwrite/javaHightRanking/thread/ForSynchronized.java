package readandwrite.javaHightRanking.thread;

/**
 * 
 * <p>Title:synchronized 方法和块的区别</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:bksx</p>
 * <p>CreateDate:2018年5月14日</p>
 * @author zohn
 * @version 1.0
 */
public class ForSynchronized {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		//for (int i = 0; i < 3; i++) {
			// new Thread(new MyThread()).start(); // 这样每次都是新来一个线程
			// new Thread(new MyThread()).start();
			// new Thread(new MyThread()).start();
			// new Thread(new MyThread()).start();
			new Thread(myThread).start(); // 结果:0-9
			new Thread(myThread).start();// 再来一个 结果:两个是无规律的,每次运行结果不一样。
		//}
	}
}

class MyThread extends Thread {
	
	public synchronized void run() { // 加上synchronized之后,就是0-9,new Thread(Obj)多少次,就有几个0-9
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
		}
	}
	
}
