package readandwrite.book.cyc2018.clone;

/**
 *@Description 浅copy 拷贝对象和原始对象的引用类型 引用同一个对象
 *@CreateDate 2021\1\25 0025 14:51
 *@Author z
 *@Version 1.0
 */
public class ShallowCloneExample implements Cloneable {
	private int[] arr;

    public ShallowCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }

    public static void main(String[] args) {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;

        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        e1.set(1,111);
        int i = e2.get(1);
        System.out.println("======^_^======variable i value is : " + i + ", " + " current method and class name is : ShallowCloneExample.main()");
    }
}
