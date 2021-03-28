package readandwrite.javaHightRanking.reflect;

public class Student {
	
	private String name;
	private String tel;
	
	public void printInfo() {
			System.out.println("打印学生信息~~~");
	}

	public void printAddress(String address) {
		System.out.println("hello, I am from " + address);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
}
