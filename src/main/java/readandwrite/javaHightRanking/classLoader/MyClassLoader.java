package readandwrite.javaHightRanking.classLoader;

public class MyClassLoader extends ClassLoader {
	
	public MyClassLoader() {
		super(MyClassLoader.class.getClassLoader());
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return super.loadClass(name);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		return super.findClass(name);
	}
	
	public static void main(String[] args) {
		
	}
	
}
