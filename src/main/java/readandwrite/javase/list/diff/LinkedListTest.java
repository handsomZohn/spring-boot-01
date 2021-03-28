package readandwrite.javase.list.diff;

import java.util.LinkedList;

public class LinkedListTest {
    public static void addFromHeaderTest(int num) {
        LinkedList<String> list = new LinkedList<String>();
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < num) {
            list.addFirst(i + "沉默王二");
            i++;
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("LinkedList从集合头部位置新增元素花费的时间" + (timeEnd - timeStart));
    }

    public static void addFromMidTest(int num) {
        LinkedList<String> list = new LinkedList<String>();
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < num) {
            int temp = list.size();
            list.add(temp / 2, i + "沉默王二");
            i++;
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("LinkedList从集合中间位置新增元素花费的时间" + (timeEnd - timeStart));
    }

    public static void addFromTailTest(int num) {
        LinkedList<String> list = new LinkedList<String>();
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < num) {
            list.add(i + "沉默王二");
            i++;
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("LinkedList从集合尾部位置新增元素花费的时间" + (timeEnd - timeStart));
    }

    /**
     * @Description linkedList头部删除
     * @Author zz
     * @Date 2021/2/28 12:45
     * @Param [num]
     * @Return void
     */
    public static void removeFromHeaderTest(int num) {
        LinkedList<String> list = new LinkedList<String>();
        int i = 0;

        while (i < num) {
            list.add(i + "沉默王二");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        list.remove(0);
        long timeEnd = System.currentTimeMillis();

        System.out.println("LinkedList从集合头部位置删除元素花费的时间" + (timeEnd - timeStart));
    }

    /**
     * @Description linkedList尾部删除
     * @Author zz
     * @Date 2021/2/28 12:45
     * @Param [num]
     * @Return void
     */
    public static void removeFromTailTest(int num) {
        LinkedList<String> list = new LinkedList<String>();
        int i = 0;

        while (i < num) {
            list.add(i + "沉默王二");
            i++;
        }
        long timeStart = System.currentTimeMillis();
        list.removeLast();
        long timeEnd = System.currentTimeMillis();

        System.out.println("LinkedList从集合尾部位置删除元素花费的时间" + (timeEnd - timeStart));
    }
}
