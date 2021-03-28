package readandwrite.book.xdclass;












import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListForPractice {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> list = Collections.synchronizedList(arrayList);

        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
    }

    @Test
    public void arrayListTest() {
        List<String> list = new ArrayList<>();
        System.out.println("======^_^======变量list.size()值为: " + list.size() + ", " + "当前类以及方法名字是: " +
                "ArrayListForPractice.arrayListTest()");
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
        System.out.println(list.size());
        list.add("xdclass.net");
        System.out.println(list.size());
    }
/*
    //计算容量?+确保容量?
    private void ensureCapacityInternal(int minCapacity) {
//如果是初次扩容，则使?用默认的容量?
        if (elementData == EMPTY_ELEMENT_DATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
//是否需要扩容，需要的最少容量??大于现在数组的?长度则要扩容
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
//如果新容量? < 最?小容量?， 则讲最新的容量?赋值给新的容量?
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
//创建新数组
            Object[] objects = new Object[newCapacity];
//将旧的数组复制到新的数组?里??面
            System.arraycopy(elementData, 0, objects, 0, elementData.length);
//修改引?用
            elementData = objects;
        }*/
    }
