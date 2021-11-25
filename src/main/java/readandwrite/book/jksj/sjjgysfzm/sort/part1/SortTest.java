package readandwrite.book.jksj.sjjgysfzm.sort.part1;

import org.junit.jupiter.api.Test;

public class SortTest {


    /**
     * @return void
     * @Author viy
     * @Description 冒泡排序
     * 1、是原地排序算法
     * 2、是稳定的排序算法
     * 3、时间复杂度：最好情况是O(n) 最坏情况是O(n^2)
     * @Date 16:47 2021/11/8
     * @Param [a, n]
     **/
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;

            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }

            // 没有数据交换 提前退出
            if (!flag) {
                break;
            }

        }
    }


    /**
     * @return void
     * @Author viy
     * @Description 插入排序
     * @Date 19:01 2021/11/8
     * @Param [a, n]
     **/
    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }

    }


    @Test
    public void testFori() {
        int i = 10;
        for (int i1 = 0; i1 < i; ++i1) {
            System.out.println(i1);
        }

        // i1++ 是0-9
        // ++i1 也是0-9
    }
}
