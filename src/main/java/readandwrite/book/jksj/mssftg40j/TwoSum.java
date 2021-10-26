package readandwrite.book.jksj.mssftg40j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 求数组中两数之和 该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标
 * @CreateDate 2021\1\27 0027 14:06
 * @Author z
 * @Version 1.0
 */
public class TwoSum {
    /**
     * @Description 暴力破解
     * @Author z
     * @Date 2021\1\27 0027 15:25
     * @Param [nums, target]
     * @Return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * @Description hashmap实现
     * @Author z
     * @Date 2021\1\27 0027 15:31
     * @Param [nums, target]
     * @Return int[]
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    private int getIndex(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new TwoSum().twoSum(new int[]{1, 9}, 10);

        int[] ints2 = new TwoSum().twoSum2(new int[]{1,56,78,44,33,77}, 100);

        System.out.println(Arrays.toString(ints));

        System.out.println(Arrays.toString(ints2));
    }
}
