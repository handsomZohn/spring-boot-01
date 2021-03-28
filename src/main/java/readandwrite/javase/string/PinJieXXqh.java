package readandwrite.javase.string;

public class PinJieXXqh {

	public static void main(String[] args) {
		String xzqhString = "('110101','110102','110105','110106','110107','110108','110109','110111','110112','110113','110114','110115','110116','110117','110228','110229','110401')";

		xzqhString = xzqhString.substring(0,xzqhString.length() - 1) + "," + "'')";
		
		System.out.println(xzqhString);
	}

}
