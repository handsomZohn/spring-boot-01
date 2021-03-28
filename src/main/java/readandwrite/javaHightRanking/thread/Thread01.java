package readandwrite.javaHightRanking.thread;

public class Thread01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Thread thread = new Thread(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			System.err.println(110);
			System.err.println(super.getClass());
			System.err.println(this.getClass());
		}
			
		};
		thread.start();
	}

}
