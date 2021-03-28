package readandwrite.javaHightRanking.jvm;

public class Jvm01 {

	int age;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getUserName() {

		double price;
		// System.out.println(price); //
		System.out.println(age);

		return "张三";
	}

}

class Jvm02 {

	public static void main(String[] args)

	{

		ClassLoader loader =

		Thread.currentThread().getContextClassLoader();

		System.out.println(loader);

		System.out.println(loader.getParent());

		System.out.println(loader.getParent().getParent());

	}

}
