package readandwrite.book.datastructure.stack;

/**
 * 数据结构-栈-java实现
 * 基于数组实现的顺序栈 (第一个元素的下标为0)
 *
 * @param <E>
 */
public class Stack<E> {
    private Object[] data = null;
    private int maxSize = 0;
    private int top = -1;


    Stack() {
        this(10);
    }

    /**
     * 构造函数 根据指定的size初始化栈 如果没有的话 初始化为10
     *
     * @param initialSize
     */
    Stack(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        } else {
            throw new RuntimeException("初始化大小不能小于等于0：" + initialSize);
        }
    }

    /**
     * 进栈 第一个元素 top=0
     *
     * @param e
     * @return
     */
    public boolean push(E e) {
        // 先判断栈是否满了
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满，无法入栈！");
        } else {
            // 细节啊 我去
            // top = -1

            // top++;
            // data[top] =  e;

            // 这一行代码 等于上面的两行 先++ 再使用
            data[++top] = e;
            return true;
        }
    }

    /**
     * 弹出栈顶的元素
     *
     * @return
     */
    public E pop() {
        if (top == -1) {
            throw new RuntimeException("空栈，无法出栈！");
        } else {

            // Object data  =  data[top];
            // top --;
            // return data;

            //  下面一行顶上面三行

            return (E) data[top--];
        }
    }

    /**
     * 查询栈顶元素 不删除数据
     *
     * @return
     */
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("空栈，无法出栈！");
        } else {
            return (E) data[top];
        }
    }

}
