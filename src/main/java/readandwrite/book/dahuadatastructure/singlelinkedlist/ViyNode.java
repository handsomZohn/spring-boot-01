package readandwrite.book.dahuadatastructure.singlelinkedlist;

/**
 * 单向链表-数据节点
 */
public class ViyNode {

    public int serialNumber;
    public String name;
    public String information;

    /**
     * 指向下一个节点
     */
    public ViyNode next;

    public ViyNode(int serialNumber, String name, String information) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.information = information;
    }

    @Override
    public String toString() {
        return "ViyNode{" +
                "serialNumber=" + serialNumber +
                ", name='" + name + '\'' +
                ", information='" + information + '\'' +
                ", next=" + next +
                '}';
    }
}
