package readandwrite.book.cyc2018;

public class AboutFinal {

	public static void main(String[] args) {
		final int i = 10;
		//i = 100; // The final local variable i cannot be assigned. It must be blank and not using a compound assignment
		
		final User user = new User();
		User user2 = new User();
		// user = user2; // The final local variable user cannot be assigned. It must be blank and not using a compound assignment
		
		// user 已经引用了一个 new User(),,,这个引用是不能变的。
		
		User.i = 100;
		System.out.println(User.i);
		user.j = user.j << 2; 
		System.err.println(user.j);
	}
}


class User{
	static int i = 10;
	
	int j = 1000;
}