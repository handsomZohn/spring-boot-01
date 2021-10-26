package readandwrite.book.algorithm.search;

/**
 * 查找算法-二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int a) {
        int low = 0;
        int height = array.length - 1;
        int mid;
        while (low < height) {
            // 中间位置
            mid = (height - low) / 2 + low;
            if (array[mid] == a) {
                return mid;
            } else if (array[mid] > a) {
                // 向左查找
                height = mid - 1;
            } else {
                // 向右 查找
                low = mid + 1;
            }
        }
        return -1;
    }
}
