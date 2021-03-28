package readandwrite.book.datastructure.queue;

/**
 * @Description 队列的java实现版本
 * @CreateDate 2021\2\8 0008 13:32
 * @Author z
 * @Version 1.0
 */
public class JavaQueue<E> {
    private Object[] data = null;

    /**
     * 队列的容量
     */
    private int maxSize;

    /**
     * 队列头 允许插入
     */
    private int front;

    /**
     * 对列尾 允许删除
     */
    private int rear;

    /**
     * @Description 默认大小为10的队列
     * @Author z
     * @Date 2021\2\8 0008 13:38
     * @Param []
     * @Return
     */
    public JavaQueue() {
        this(10);
    }

    /**
     * @Description 带参数构造
     * @Author z
     * @Date 2021\2\8 0008 13:39
     * @Param [initialSize]
     * @Return
     */
    public JavaQueue(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    /**
     * 队列尾部插入数据[入队操作]
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满，无法插入新的元素！");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    /**
     * 删除队列头部的元素：[出队]
     *
     * @return
     */
    public E poll() {
        if (rear == 0) {
            throw new RuntimeException("空队列异常！");
        } else {
            // 队列front端的元素的值
            E value = (E) data[front];
            data[front++] = null;
            return value;
        }
    }

    /**
     * 取出队列头部的元素，不删除 （不出队）
     *
     * @return
     */
    public E peek() {
        if (rear == 0) {
            throw new RuntimeException("空队列异常！");
        } else {
            return (E) data[front];
        }

    }
}
