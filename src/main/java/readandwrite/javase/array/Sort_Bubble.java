package readandwrite.javase.array;
public class Sort_Bubble {
	public static void main(String[] args) {
		yxdd(); // 由小到大
		yddx(); // 由大daoxi
	}
	
	//由小到大
	public static void yxdd(){
	int[] arr = {23,12,3,45,25,46,75,15,12,52};
		
		for(int i=arr.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
//查看结果~~
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
	}

	//由大到小
	public static void yddx(){
		int[] arr = {23,12,3,45,25,46,75,15,12,52};
		for(int i=0;i<=arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]<arr[j]){     // 改变括号的方向 改变 排序的顺序
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
//查看结果~~
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}