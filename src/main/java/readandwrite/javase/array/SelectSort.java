package readandwrite.javase.array;

public class SelectSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectSort();
		int n = 10, m = 20;
		//System.out.println(n^m^m);
	}

	public static void selectSort(){
		int[] arr = {1,34,43,45,54};
		int arrLen = arr.length;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				
					if(arr[i]>arr[j]){
						int temp;
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				
			}
		}
		for (int i = 0; i < arrLen; i++) {
			System.out.println(arr[i]);
		}
	}
}
