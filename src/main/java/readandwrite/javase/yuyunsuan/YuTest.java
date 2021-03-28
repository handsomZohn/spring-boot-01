package readandwrite.javase.yuyunsuan;


public class YuTest {

	public static void main(String[] args) {
		int n = 10;
		int m = 200;
		n = m^n;
		m = m^n;
		n = m^n;
		System.err.println(n+","+m);
	}
}
