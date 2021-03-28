package readandwrite.javase.guanjianzi;

import java.io.*;

public class TransientTest {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("zohn");
		user.setPassword("123456789");
		System.out.println("read before Serializable:");
		System.out.printf("username:%s", user.getUsername() + ", ");
		System.out.printf("password:%s", user.getPassword());
		
		// String string = "string";
		// System.out.
		// ("%s", string);// 1.4不支持
		
		// 序列化
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e:/user.txt"));
			oos.writeObject(user);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 反序列化
		try {
			// 反序列化之前更改name的值
			// User.username = "songminglu";// 反序列化后类中static型变量username的值为当前JVM中对应static变量的值
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e:/user.txt"));
				user = (User)ois.readObject();
				ois.close();
				System.out.println("\nread after Serializable:");
				System.out.printf("username:%s", user.getUsername() + ", ");
				System.out.printf("password:%s", user.getPassword());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

/**
 * 对于不想序列化的变量，使用transient关键字修饰
 * 当对象被序列化是：阻止实例中那些用此关键字修饰的变量序列化
 * 当对象被反序列化时，被transient修饰的变量值不会被持久化和恢复
 * tranient只能修饰变量，不能修改时类和方法。
 */
class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String username; // static
	transient private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}