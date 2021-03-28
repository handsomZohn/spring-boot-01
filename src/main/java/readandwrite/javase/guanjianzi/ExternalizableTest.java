package readandwrite.javase.guanjianzi;

import java.io.*;

public class ExternalizableTest implements Externalizable {

	private transient String content = "不管我是否被transient修饰只要被手工指定要序列化我都会序列化";
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(content);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		content = (String) in.readObject();
	}

	public static void main(String[] args) throws ClassNotFoundException {
		ExternalizableTest et = new ExternalizableTest();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("e:/test.txt")));
			oos.writeObject(et);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("e:/test.txt")));
			et = (ExternalizableTest) ois.readObject();
			System.out.println(et.content);
			ois.close();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
