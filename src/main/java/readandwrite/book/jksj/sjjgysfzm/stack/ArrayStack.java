package readandwrite.book.jksj.sjjgysfzm.stack;

/**
 * 基于数组实现的顺序栈
 */
public class ArrayStack {

    /**
     * 数组
     */
    private String[] items;
    /**
     * 栈中元素的个数
     */
    private int count;
    /**
     * 栈的大小
     */
    private int n;

    /**
     * 初始化数组 申请一个大小为n的数组空间
     *
     * @param n
     */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 入栈操作
     *
     * @param item
     * @return
     */
    public boolean push(String item) {
        if (count == n) {
            // 数组空间已满
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public String pop() {

        // 栈为空 直接返回
        if (count == 0) {
            return null;
        }
        // 返回下标为count-1的数组元素 并且栈中元素个数count减一
        String temp = items[count - 1];
        --count;
        return temp;
    }
}
