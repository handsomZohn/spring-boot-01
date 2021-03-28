package readandwrite.book.datastructure.binarysearchtree;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node root;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    /**
     * 向二叉排序树中插入节点
     *
     * @param key
     */
    public void insertBST(int key) {
        Node p = root;

        // 查找节点的前一个节点
        Node prev = null;

        // 一直查找下去，直到达到满足条件的节点位置
        while (p != null) {
            prev = p;
            if (key < p.getValue()) {
                p = p.getLeft();
            } else if (key > p.getValue()) {
                p = p.getRight();
            } else return;
        }

        // prev 是待插入节点的父节点，根据节点值的大小，新建节点并将其插入相应的位置
        if (root == null) {
            root = new Node(key);
        } else if (key < prev.getValue()) {
            prev.setLeft(new Node(key));
        } else prev.setRight(new Node(key));
    }


    /**
     * 删除二叉遍历树中的节点，分为三种情况：：（删除节点为*p，其父节点为*f）
     * （1）要删除的*p节点是叶子节点，只需修改它的双亲节点的指针为空
     * （2）若*p只有左子树或者只有右子树，则直接让左子树或右子树代替*p
     * （3）若*P既有左子树又有右子树，则用p左树中最大的值（即最右端s）代替p，删除s，重接其左子树
     *
     * @param key
     */
    public void deleteBST(int key) {
        deleteBST(root, key);
    }


    private boolean deleteBST(Node node, int key) {
        if (node == null) {
            return false;
        } else {
            if (key == node.getValue()) {
                return delete(node);
            } else if (key < node.getValue()) {
                return deleteBST(node.getLeft(), key);
            } else return deleteBST(node.getRight(), key);
        }
    }

    private boolean delete(Node node) {
        Node temp = null;

        /**
         * 右子树为空，只需要重接它的左子树
         * 如果是叶子节点，则这里也把叶子节点删除
         */
        if (node.getRight() == null) {
            temp = node;
            node = node.getLeft();
        } else if (node.getLeft() == null) {
            temp = node;
            node = node.getRight();
        } else {
            temp = node;
            Node s = node;
            /**
             * 转向左树节点，然后向右走到尽头
             */
            s = s.getLeft();
            while (s.getRight() != null) {
                temp = s;
                s = s.getRight();
            }
            node.setValue(s.getValue());
            if (temp != node) {
                temp.setRight(s.getLeft());
            } else {
                temp.setLeft(s.getLeft());
            }
        }
        return true;
    }

    /**
     * @param key
     * @return
     */
    public boolean searchBST(int key) {
        Node current = root;
        while (current != null) {
            // 等于当前值，则查找成功，返回值
            if (key == current.getValue()) {
                return true;
            } else if (key < current.getValue()) {// 比当前值小进入左子树查找
                current = current.getLeft();
            } else current = current.getRight();//  比当前值大，进入右节点查找
        }
        return false;
    }

    public static void main(String[] args) {
        // 新建节点
        Node node = new Node(20);
        for (int i = 0; i < 5; i++) {
            node.insertBST(i);
        }

        boolean b = node.searchBST(0);

        // true 表示查找成功
        System.out.println(b);
    }
}
