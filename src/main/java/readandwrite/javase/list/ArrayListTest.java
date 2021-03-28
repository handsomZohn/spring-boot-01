package readandwrite.javase.list;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		System.out.println(list);
		list.clear();
		System.out.println(list);
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		Object[] array = list.toArray(); 
		System.out.println(array);
		for (int i = 0; i < list.toArray().length; i++) {
			System.out.println(list.toArray()[i]);
		}
	}
}
