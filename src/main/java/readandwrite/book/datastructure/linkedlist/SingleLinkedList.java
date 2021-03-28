package readandwrite.book.datastructure.linkedlist;


/**
 * @Description 单向列表java实现
 * @CreateDate 2021\2\8 0008 14:00
 * @Author z
 * @Version 1.0
 */
public class SingleLinkedList {
    /**
     * 链表节点的个数
     */
    private int length;

    /**
     * 头节点
     */
    private Node head;

    public SingleLinkedList() {
        length = 0;
        head = null;
    }

    private class Node {
        /**
         * 每个节点的数据
         */
        private Object data;

        /**
         * 每个节点指向下一个节点的链接
         */
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 链表中添加数据
     *
     * @param object
     * @return
     */
    public Object addHead(Object object) {
        // 第一步定义新节点
        Node newHead = new Node(object);

        // 第二步如果链表为空，则将该节点设置为头部节点
        if (length == 0) {
            head = newHead;
        } else {
            //  第三步 设置当前节点为头部节点，并将当前节点的下一个节点指向原来的头部节点
            head = newHead;
            newHead.next = head;
        }
        // 第四步 链表长度+1
        length++;
        return object;
    }

    /**
     * 删除指定的元素 如果删除成功就返回true
     *
     * @param value
     * @return
     */
    public boolean delete(Object value) {
        if (length == 0) {
            return false;
        }

        Node current = head;
        Node previous = head;
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }

        // 如果删除的节点是头结点
        if (current == head) {
            head = current.next;
            length--;
        } else {// 删除的节点不是头节点
            previous.next = current.next;
            length--;
        }
        return true;
    }

    /**
     * 查找指定的元素，若找到则返回，否则返回null
     *
     * @param object
     * @return
     */
    public Node find(Object object) {
        Node current = head;
        int tempSize = length;
        while (tempSize > 0) {
            if (object.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }
}
