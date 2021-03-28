package readandwrite.book.algorithm.sort;

/**
 * 排序·算法-冒泡排序
 */
public class Bubblesort {

    public static int[] bubbleSort(int[] arr) {
        // 外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + i];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
