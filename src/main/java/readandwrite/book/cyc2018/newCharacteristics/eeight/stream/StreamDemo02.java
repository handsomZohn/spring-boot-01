package readandwrite.book.cyc2018.newCharacteristics.eeight.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * https://blog.csdn.net/zxc123e/article/details/50533760
 *
 * @Description ʹ��map()������һ�������ӡ�����������ArrayList��ֵ��ƽ�����ĳ˻���Ԫ�ص�ƽ����������ӳ�䵽һ��������Ȼ��
 * ʹ��reduce()��������˻���
 * �����ʾ�˸�����������
 * @CreateDate 18/09/17 11:39
 * @Author zohn
 * @Version 1.0
 */
public class StreamDemo02 {

    public static void main(String[] args) {

        ArrayList<Double> myList = new ArrayList<>();
        myList.add(7.0);
        /*myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(5.0);*/

        // ӳ��Ԫ�ص�ƽ����������
        // Stream<Double> stream = myList.stream((i) -> i);
        // Double reduce = stream.reduce(1.0, (a, b) -> (a * b));
        // System.out.println("product of square roots is " + reduce);
    }
}
