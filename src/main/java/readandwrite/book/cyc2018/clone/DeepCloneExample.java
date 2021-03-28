package readandwrite.book.cyc2018.clone;

/**
 *@Description 深度copy 拷贝对象和原始对象的引用类型引用不同的对象
 *@CreateDate 2021\1\25 0025 14:52
 *@Author z
 *@Version 1.0
 */
public class DeepCloneExample implements Cloneable{
    private int[] arr;

    public DeepCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample result = (DeepCloneExample) super.clone();
        result.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result.arr[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        DeepCloneExample d1 = new DeepCloneExample();
        DeepCloneExample d2 = null;
        try {
            d2 = d1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        d1.set(1,111);
        int i = d2.get(1);
        System.out.println("======^_^======variable i value is : " + i + ", " + " current method and class name is : DeepCloneExample.main()");
    }
}
