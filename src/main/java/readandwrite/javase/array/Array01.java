package readandwrite.javase.array;

import java.util.Arrays;

/**
 * Created by  on 2016-09-26.
 * 2,3 查找功能
 * 4,5,6 排序功能
 * 需求：1、将给定数组的元素全部输出放到[]，格式类似 [a,d,f,g]
 * 2、求给定数组元素的最大值
 * 3、折半查找
 * 4、选择排序
 * 5、冒泡排序
 * 6、随代码附赠【开发中用的java自带排序方法】
 */
public class Array01 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 45, 56, 32, 54, 56};
        //3、用到arr02
        int[] arr02 = {10, 13, 16, 36, 45, 78, 89, 156};
        //1、打印数组[原样打印]
        System.out.println("------yuanyangdayin---------");
        printArr(arr);
        //2、获取数组的最大值
        System.out.println("------max---------");
        getMax(arr);
        //3、折半查找 对有序的数组就行折半查找 查找下标 是？
        System.out.println("------halfSearch---------");
        int halfSearch = halfSearch(arr02, 45);
        System.out.println(halfSearch);
        //4、选择排序
        System.out.println("------selectSort---------");
        selectSort(arr);
        //5、冒泡排序
        System.out.println("------bubbleSort---------");
        bubbleSort(arr);

        //6、用java 自带的 排序方式[底层封装]
        System.out.println("------Arrays.sort---------");
        Arrays.sort(arr);
        printArr(arr);
    }

    /**
     * 打印数组
     *
     * @param arr 传入数组
     */
    static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < getLength(arr); i++) {
            if (i != (getLength(arr) - 1)) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.println(arr[i] + "]");
            }
        }
    }


    /**
     * 获取数组当中的最大值
     *
     * @param arr
     */
    static void getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < getLength(arr); i++) {
            if (arr[i] > arr[max]) max = i;
        }
        System.out.println("该数组的数组元素最大值是：" + arr[max]);
    }

    /**
     * 折半查找
     *
     * @param arr02 传入数组
     * @param key   元素
     * @return
     */
    static int halfSearch(int arr02[], int key) {
        int min, mid, max;
        min = 0;
        max = arr02.length - 1;
        mid = (min + max) / 2;
        while (key != arr02[mid]) {
            if (key > arr02[mid]) {
                min = mid + 1;
            }
            if (key < arr02[mid]) {
                max = mid - 1;
            }
            //表示不存在该元素
            if (min > max) {
                return -1;
            }
            mid = (min + max) / 2;
        }
        return mid;
    }
    //排序 第一种方式，选择排序
    //getLength（arr）-1 表示，最后一个元素，就不进行循环比较，因为就剩下一个
    //i = 0，j = i+1 ，表示，总是前后两个元素相比，不会出现同一个元素做比较的情况；

    /**
     * getLength（arr）-1 表示，最后一个元素，就不进行循环比较，因为就剩下一个
     * i = 0，j = i+1 ，表示，总是前后两个元素相比，不会出现同一个元素做比较的情况；
     *
     * @param arr
     */
    static void selectSort(int[] arr) {
        for (int i = 0; i < (getLength(arr) - 1); i++) {
            for (int j = i + 1; j < getLength(arr); j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        printArr(arr);
    }

    //冒泡排序
    static void bubbleSort(int[] arr) {
        for (int x = 0; x < getLength(arr) - 1; x++) {
            for (int y = 0; y < getLength(arr) - x - 1; y++) {
                //不加if判断条件，默认按照数组元素从大到小【倒序】的顺序排列
                if (arr[y] > arr[y + 1]) {
                    swap(arr, y, y + 1);
                }
            }
        }
        printArr(arr);
    }

    //封装的方法，用来获取 数组的长读

    /**
     * @param arr
     * @return 数组的长度
     */
    static int getLength(int[] arr) {
        return arr.length;
    }
    //排序时，要进行位置的交换，这是调换位置的方法

    /**
     * @param arr 传入数组
     * @param a   下标a
     * @param b   下标b
     */
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    //
}
