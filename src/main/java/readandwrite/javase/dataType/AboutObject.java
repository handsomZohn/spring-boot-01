package readandwrite.javase.dataType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * <p>Title:</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:bksx</p>
 * <p>CreateDate:2018年6月22日</p>
 * @author Administrator
 * @version 1.0
 */
public class AboutObject {
	public static void main(String[] args) {
		Map hasMap = new HashMap();
		Set haSet = new HashSet();
		int[] arr = new int[10];
		User user = new User();
		// Object数组可以放基本类型数组就是不能放基本类型
		// Object[] object = new Object[]{"string", hasMap, haSet, arr, user, 10};
		
		Object[] object = null;
		// 这是在逆天吗
		// System.out.println(object.length);
	}
	
	
}

class User{
	public User() {
		
	}
}
