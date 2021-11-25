package readandwrite.book.jksj.sjjgysfzm.queue;

/**
 * 基于数组实现的顺序栈
 */
public class ArrayQueue {
    /**
     * 数组：items
     */
    private String[] items;

    /**
     * 数组大小为n
     */
    private int n = 0;

    /**
     * 队头下标
     */
    private int head = 0;

    /**
     * 队尾下标
     */
    private int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     * @param capacity
     */
    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队操作
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        // 队列已满
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队操作
     * @return
     */
    public String dequeue(){
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String item = items[head];
        ++head;
        return item;
    }

    public void printAll(){
        for (int i = head; i < tail; i++) {
            System.out.println(items[i] + "  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

    }
}
