package readandwrite.javase.dataType;

public class AboutStr {

	public static void main(String[] args) {
//		 tm1();
//		 tm2();
//		 tm3();
//		 tm4();
		 tm5();
	}

	static void tm1() {
		String name1 = "zhangyifeng";
		String name2 = "zhang" + "yifeng"; // 编译期优化为: name2 = "zhangyifeng";
		System.out.println(name1 == name2);// true
	}

	static void tm2() {
		String name1 = "zhangyifeng";
		String name2 = "zhang";
		String name3 = name2 + "yifeng"; // 不会在编译期间优化 不会把b+2当做字面常量来处理的
		System.out.println(name1 == name3);// false
	}

	static void tm3() {
		String name1 = "zhangyifeng";
		final String name2 = "zhang";
		String name3 = name2 + "yifeng";// 对于被final修饰的变量，会在class文件常量池中保存一个副本，也就是说不会通过连接而进行访问，对final变量的访问在编译期间都会直接被替代为真实的值
		System.out.println(name1 == name3);// true
	}

	static void tm4() {
		String string = "hello2";
		final String string2 = getHello();
		String string3 = string2 + "2";	// string2虽然被final修饰
										// 但是由于其赋值是通过方法调用返回的，那么它的值只能在运行期间确定，因此string和String3
										// 指向的不是同一个对象。
		System.out.println(string == string3);// false
	}

	static String getHello() {
		return "hello";
	}

	static void tm5() {
		String str1 = "hello";
		String str2 = new String("hello");
		String str3 = new String("hello");
		String str4 = str2.intern();// String.intern()
									// Java6之前会去运行时常量池查找有没有内容相同的字符串存在则返回指向该字符串的引用，如果不存在，
									// 则会将该字符串入池，并返回一个指向该字符串的引用。

		System.out.println(str1 == str2);// false
		System.out.println(str2 == str3);// false
		System.out.println(str2 == str4);// false
		System.out.println(str1 == str4);// true
	}

	static void tm6() {
		// 创建多少个对象
		String string = new String("String");
		// new只调用了一次，也就是说只创建了一个对象
		// 这个问题如果换成 String str = new String("abc")涉及到几个String对象？合理的解释是2个。
		// 向面试官询问清楚”是这段代码执行过程中创建了多少个对象还是涉及到多少个对象
	}

	static void tm7() {
		String str1 = "I";
		// str1 += "love"+"java"; 1)
		str1 = str1 + "love" + "java"; // 2)
		//　1)的效率比2)的效率要高，1)中的"love"+"java"在编译期间会被优化成"lovejava"，而2)中的不会被优化。
		// 在1)中只进行了一次append操作，而在2)中进行了两次append操作。
	}
}
