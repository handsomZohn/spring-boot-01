package readandwrite.javase.array;


import java.util.Arrays;

/**
 *@Description 冒泡排序的变种
 *@CreateDate 2020/4/15 22:41
 *@Author zz
 *@Version 1.0
 */
public class TwoDimensionalArray {
    public static void main(String[] args) {

        // 二维数组排序--原数组
        String[][] strs = {{"12", "Java"},{"25", "Ruby"},{"55", "Python"},{"30", "Golang"},{"7", "JavaScript"}};
        // 新建数组
        int[] arr = new int[strs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strs[i][0]);
        }
        //第一次循环，是确定一个数依次和后面数的比较的数。
        for (int i = 0; i < arr.length -1 ; i++) {
            //这个是和第一个数的比较的数
            for (int j = i+1; j < arr.length; j++) {
                //定义一个临时的变量，用来交换变量交换的是原二维数组的变量
                String[] temp;
                if(arr[i]<arr[j]){
                    temp =  strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(strs[i][0]);
        }


        // Arrays.stream(strs).
    }
}
