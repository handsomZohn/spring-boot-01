package readandwrite.book.dahuadatastructure.singlelinkedlist;

/**
 * 单向链表-具体实现
 */
public class SingleLinkedList {
    /**
     * 定义头部节点 不存放数据
     */
    private ViyNode headNode = new ViyNode(0, "", "");

    /**
     * 顺序添加
     *
     * @param viyNode
     */
    public void sequenceAdd(ViyNode viyNode) {

        // 定义辅助变量 从开头开始遍历 查找可以插入元素的位置
        ViyNode temp = headNode;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.serialNumber > viyNode.serialNumber) {
                // 进入此判断 说明找到相应的位置了，在temp后面插入
                break;
            } else if (temp.next.serialNumber == viyNode.serialNumber) {
                // 说明添加信息已存在
                flag = true;
            }
            // 后移 遍历列表
            temp = temp.next;
        }
        if (flag) {
            System.out.println("信息已存在");
        } else {
            // 插入链表
            viyNode.next = temp.next;
            temp.next = viyNode;
        }
    }

    /**
     * 链表遍历方法
     */
    public void traverse() {
        // 判断链表是否为空
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 定义辅助变量 遍历链表
        ViyNode temp = headNode.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 修改链表某个node属性的方法
     * @param node
     */
    public void update(ViyNode node) {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 定义辅助变量
        ViyNode temp = headNode.next;

        // 定义标志 用来标志有没有找到对应的flag
        boolean flag = false;

        // 先查找到对应的node
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.serialNumber == node.serialNumber) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            // 修改名字和信息 不修改序列号
            temp.name = node.name;
            temp.information = node.information;
        } else {
            System.out.println("没有找到~~");
        }
    }

    /**
     * 删除方法
     * @param serialNumber
     */
    public void delete(int serialNumber){
        ViyNode temp = headNode;
        boolean flag = false;
        while (true){
            if (temp.next == null) {
                break;
            }
            if (temp.next.serialNumber == serialNumber) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.next = temp.next.next;
        }

    }
}
