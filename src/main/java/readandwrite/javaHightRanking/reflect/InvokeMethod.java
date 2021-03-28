package readandwrite.javaHightRanking.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InvokeMethod {

	/**
	 * 通过反射调用类中的方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			// 反射创建类实例的三种方式
			Class<?> student = Class.forName("com.javaHightRanking.reflect.Student"); // 1、动态加载
			student = Student.class; // 2、调用静态属性
			Student stu = new Student();
			stu.setName("zhangyifeng");
			stu.setTel("15565668401");
			student = stu.getClass(); // 3、调用实例对象的getClass();

			// 通过反射代用对象的方法
			Method method = student.getMethod("printInfo"); // 获取方法 参数是方法的名字
			method.invoke(student.newInstance()); // 通过实例调用方法
			Method method2 = student.getMethod("printAddress", String.class); // 参数是方法的名字和该方法所需的参数类型
			method2.invoke(student.newInstance(), "王庄小学");

			// 反射获取和设置对象私有字段的值
			Field name = student.getDeclaredField("name");
			Field tel = student.getDeclaredField("tel");
			Field[] fields = student.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true); // 这一步很重要 false Class
											// com.reflect.InvokeMethod can not
											// access a member of class
											// com.reflect.Student with
											// modifiers "private"
				System.out.println(field.get(stu)); // 获取是有属性
			}
			name.setAccessible(true);
			name.set(stu, "张三"); // 修改私有属性
			tel.setAccessible(true);
			tel.set(stu, "18310834045");
			// 修改过后的值:
			System.out.println("修改过后的name属性值:" + name.get(stu));
			System.out.println("修改过后的tel属性值:" + tel.get(stu));
			Field[] fields2 = student.getDeclaredFields(); // fields2 第二个定义的也需要 若是用的同一个 则不需要再次setAccessible()
															// setAccessible(true)
			for (Field field : fields2) {
				field.setAccessible(true);
				System.err.println(field.get(stu));
			}
			
			// 

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("发生异常----构建失败----");
		} /*
		 * finally { System.out.println("总是会经过的~~~"); }
		 */
	}

}
