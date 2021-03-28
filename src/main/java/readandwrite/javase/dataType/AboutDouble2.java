package readandwrite.javase.dataType;

public class AboutDouble2 {

	public static void main(String[] args) {
		//System.out.println(new Double(100)-32.52-55.16);
		
		String a = "32.52%";
		String b = "55.16%";
		double d = new Double(a.substring(0,a.indexOf("%")));
		double e = new Double(b.substring(0,b.indexOf("%")));
		System.out.println(d);
		System.out.println(e);
		System.out.println(100-d-e);
	}
}
