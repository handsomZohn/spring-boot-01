package readandwrite.book.dahuadatastructure.singlelinkedlist;

/**
 * 单项链表测试类
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void singleLinkedListfTest() {
        ViyNode viyNode1 = new ViyNode(1, "张", "湖北");
        ViyNode viyNode2 = new ViyNode(2, "孙", "悟空");
        ViyNode viyNode3 = new ViyNode(3, "猪", "八戒");
        ViyNode viyNode4 = new ViyNode(4, "英山", "茗茶");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.sequenceAdd(viyNode1);
        singleLinkedList.sequenceAdd(viyNode2);
        singleLinkedList.sequenceAdd(viyNode3);
        singleLinkedList.sequenceAdd(viyNode4);
        System.out.println("=================================插入之后的遍历=============================================");
        singleLinkedList.traverse();

        System.out.println("=================================修改之后的遍历=============================================");
        ViyNode viyNode = new ViyNode(2,"行者","孙");
        singleLinkedList.update(viyNode);
        singleLinkedList.traverse();

        System.out.println("=================================删除之后的遍历=============================================");
        singleLinkedList.delete(2);
        singleLinkedList.traverse();
    }
}
