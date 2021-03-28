package readandwrite.javase.array;
/*一个不确定数目及不确定排列顺序的字符串数组，已知包含这四个元素 "admin" "viewer" "operator" "designer", 
在你输入一个不确定大小和顺序的数组后(仅包含上述四个字符的任意一个和几个，元素不重复) ，算法会按照 
"admin" "viewer" "operator" "designer"这个顺序重新生成数组，如： 
String[] a={ "viewer" ,"admin"} ---> String[] b={"admin", "viewer" } 
designer operator --->operator designer 
operator  viewer admin --->admin viewer  operator  
viewer designer operator admin  --->admin  viewer operator designer 
就是紧包含这四个string对象的 新的+不确定的数组（元素就这个四个中的一个或者两个，或者三个或者四个，且不重复）的排序*/

import java.util.Arrays;
import java.util.List;

public class SortStingArray {

	//参照标准 序列
	private List<String> referList=Arrays.asList("admin", "viewer", "operator", "designer");
	private String[] lscpvb = {"admin","viewer","operator","designer"};
	//待处理序列
	private List<String> targetList;
	
	//构造方法
	public SortStingArray(String[] array){
		this.targetList=Arrays.asList(array);
	}	
	//排序
	public String[] sort(){
		for(int i=this.referList.size()-1; i>=0 ;--i){
			if(this.targetList.contains(this.referList.get(i))){
				continue;
			}
		}
		return (String[])this.referList.toArray();
	}
	//打印函数
	public void print(){
		for(String temp:this.targetList){
			System.out.println(temp);
		}
	}
	//测试代码
	public static void main(String[] args) {
		SortStingArray s=new SortStingArray(new String[]{"operator","viewer","admin"});
		s.sort();
		s.print();
	}
}
