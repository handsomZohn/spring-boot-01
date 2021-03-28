package readandwrite.book.jksj.mssftg40j;

import java.util.Stack;

/**
 *@Description 反转列表
 *@CreateDate 2021\2\2 0002 16:01
 *@Author z
 *@Version 1.0
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode listNode = new ReverseLinkedList().reverseList(head);
        System.out.println("======^_^======variable listNode value is : " + listNode + ", " + " current method and class name is : ReverseLinkedList.main()");
    }

    /**
     * 通过栈结构去实现反转列表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = stack.pop();
        ListNode tailNode = newHead;
        while (!stack.isEmpty()){
            ListNode cur = stack.pop();
            tailNode.next = cur;
            tailNode = cur;
        }
        tailNode.next = null;
        return newHead;
    }


}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}