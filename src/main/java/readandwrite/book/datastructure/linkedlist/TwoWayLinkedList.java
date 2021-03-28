package readandwrite.book.datastructure.linkedlist;

import java.sql.DatabaseMetaData;

/**
 *@Description  双向列表 java版本实现
 *@CreateDate 2021\2\9 0009 9:23
 *@Author z
 *@Version 1.0
 */
public class TwoWayLinkedList {

    // 链表头部
    private Node head;
    // 链表尾部
    private Node tail;
    // 链表长度
    private int size;

    // 存储数据的节点
    private class Node{
        // 节点数据
        private Object data;
        // 下一个节点
        private Node next;
        // 上一个节点
        private Node prev;
        public Node(Object data) {
            this.data = data;
        }
    }

    public TwoWayLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * 链表头部 插入节点
     * @param value
     */
    public void addHead(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size ++;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size ++;
        }
    }

    /**
     * 链表尾部 增加节点
     * @param value
     */
    public void addTail(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
    }

    /**
     * 删除链表的头部节点
     * @return
     */
    public Node deleteHead() {
        Node temp = head;
        if (size != 0) {
            head = head.next;
            head.prev = null;
            size --;
            return temp;
        } else {
            return null;
        }
    }

    /**
     * 删除链表的尾部节点
     * @return
     */
    public Node deleteTail() {
        Node temp = tail;
        if (size == 0) {
            tail = tail.prev;
            tail.next = null;
            size --;
            return temp;
        } else {
            return null;
        }
    }
}
