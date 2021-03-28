package readandwrite.javase.list.diff;

import java.util.ArrayList;

public class ArrayListTest {
    public static void addFromHeaderTest(int num) {
        ArrayList<String> list = new ArrayList<String>(num);
        int i = 0;

        long timeStart = System.currentTimeMillis();

        while (i < num) {
            list.add(0, i + "沉默王二");
            i++;
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("ArrayList从集合头部位置新增元素花费的时间" + (timeEnd - timeStart));
    }

    public static void addFromMidTest(int num) {
        ArrayList<String> list = new ArrayList<String>(num);
        int i = 0;

        long timeStart = System.currentTimeMillis();
        while (i < num) {
            int temp = list.size();
            list.add(temp / 2 + "沉默王二");
            i++;
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("ArrayList从集合中间位置新增元素花费的时间" + (timeEnd - timeStart));
    }

    public static void addFromTailTest(int num) {
        ArrayList<String> list = new ArrayList<String>(num);
        int i = 0;

        long timeStart = System.currentTimeMillis();

        while (i < num) {
            list.add(i + "沉默王二");
            i++;
        }

        long timeEnd = System.currentTimeMillis();

        System.out.println("ArrayList从集合尾部位置新增元素花费的时间" + (timeEnd - timeStart));
    }

    /**
     * @Description arrayList头部删除
     * @Author zz
     * @Date 2021/2/28 12:44
     * @Param [num]
     * @Return void
     */
    public static void removeFromHeaderTest(int num) {
        ArrayList<String> list = new ArrayList<String>(num);
        int i = 0;

        while (i < num) {
            list.add(i + "沉默王二");
            i++;
        }

        long timeStart = System.currentTimeMillis();
        list.remove(0);
        long timeEnd = System.currentTimeMillis();

        System.out.println("ArrayList从集合头部位置删除元素花费的时间" + (timeEnd - timeStart));
    }

    /**
     * @Description arrayList尾部删除
     * @Author zz
     * @Date 2021/2/28 12:44
     * @Param [num]
     * @Return void
     */
    public static void removeFromTailTest(int num) {
        ArrayList<String> list = new ArrayList<String>(num);
        int i = 0;

        while (i < num) {
            list.add(i + "沉默王二");
            i++;
        }

        long timeStart = System.currentTimeMillis();
        list.remove(num-1);
        long timeEnd = System.currentTimeMillis();

        System.out.println("ArrayList从集合尾部位置删除元素花费的时间" + (timeEnd - timeStart));
    }
}
