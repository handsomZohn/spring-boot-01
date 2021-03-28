package readandwrite.book.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

/**
 * @Description
 * @CreateDate 18/07/30 17:42
 * @Author zohn
 * @Version 1.0
 */
public class ForEachTest {
    public static void main(String[] args) {
        // iteratorRemove();
        //
        testForLoopRemove();
    }

    private static void iteratorRemove() {
        List<String> arrList = new ArrayList<>();// diamond语法
        arrList.add("1");
        arrList.add("2");
        arrList.add("3");
        // 正例
        /*Iterator<String> iterator = arrList.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if ("1".equals(string)) {
                iterator.remove();
            }
        }*/

        // 反例
		/*for (String string : arrList) {
			if ("1".equals(string)) {
				arrList.remove(string);// java.util.ConcurrentModificationException
			}
		}*/

        // 数组{"1", "1", "1", "2", "3", "4", "5"}中删除1

        // 首先转为list
        List<String> integerList = new ArrayList<>(); //Arrays.asList("1", "1", "1", "2", "3", "4", "5");// Arrays.asList
        /*integerList.add("1");
        integerList.add("1");
        integerList.add("1");*/
        integerList.addAll(Arrays.asList("1", "1", "1", "2", "3", "4", "5"));// Arrays.asList 这样就可以操作了；；；；
        /*@SafeVarargs
        @SuppressWarnings("varargs")
        public static <T> List<T> asList(T... a) {
            return new ArrayList<>(a);
        }*/

        // 是Arrays类里面的一个内部类 并没有实现add(E e), remove(int index)和remove(Object o)等方法，自然是不可修改的

        //
        // 用反例的那种方法是不可以的 因为会抛出java.util.ConcurrentModificationException

        // 用正例的那种方法
        Iterator<String> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("1".equals(next)) {
                iterator.remove();
            }
        }
       /* for (int i = 0; i < integerList.size(); i++) {
            int val = integerList.get(i);
            if (val == 1) {
                integerList.remove(val);
            }
        }
        */

        // 发现只移除掉了一个


        // 最后转为str输出
        String string = integerList.toString();
        System.out.println(string);
    }


    public static void testForLoopRemove() {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("1", "1", "1", "2", "3", "4", "5"));

        // 会抛出ConcurrentModificationException的foreach删除法
        // 和Itr迭代器有关系
        // for (String str : list) {
        //     if ("1".equals(str)) {
        //         list.remove(str);
        //     }
        // }

        for (int i = 0; i < list.size(); i++) {
            if ("1".equals(list.get(i))) {
                list.remove(i--);// i-- 妙啊
            }
        }
        System.out.println(list.toString());
    }

    /**
     * 数组不能伸缩吧
     */
    public static void testForLoopRemove02(){
        int[] arr = {1,2,1,1,1,1};
        for (int i = 0; i < arr.length; i++) {
            if (1 == arr[i]) {
                //arr[i].
            }
        }
    }
}
