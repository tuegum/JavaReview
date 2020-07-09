package review.lianbiao;

/**
 * 遍历单链表
 */
public class Node {
    private static Node head = new Node();
    //数据域
    public Integer data;

    //指针域，指向下⼀个节点
    public Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * 向链表添加数据
     *
     * @param value 要添加的数据
     */
    public static void addData(int value) {
        //初始化要加⼊的节点
        Node newNode = new Node(value);
        //临时节点
        Node temp = head;
        // 找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        // 已经包括了头节点.next为null的情况了～
        temp.next = newNode;
    }

    public static void traverse(Node head) {

        //临时节点，从⾸节点开始
        Node temp = head.next;
        while (temp != null) {
            if (temp.data != null) {
                System.out.println(temp.data);
            }
            //继续下⼀个
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addData(1);
        addData(2);
        addData(3);
        addData(4);
        traverse(head);
        System.out.println("========");
        insertNode(head,2,486);
        traverse(head);
        System.out.println("=======");
        deleteNode(head,1);
        traverse(head);
    }

    /**
     * 向单链表插入节点
     * @param head
     * @param index
     * @param value
     */
    public static void insertNode(Node head, int index, int value) {
        //⾸先需要判断指定位置是否合法，
        if (index < 1 || index > linkListLength(head) + 1) {
            System.out.println("插⼊位置不合法。");
            return;
        }
        //临时节点，从头节点开始
        Node temp = head;
        //记录遍历的当前位置
        int currentPos = 0;
        //初始化要插⼊的节点
        Node insertNode = new Node(value);
        while (temp.next != null) {
            //找到上⼀个节点的位置了
            if ((index - 1) == currentPos) {
                //temp表示的是上⼀个节点
                //将原本由上⼀个节点的指向交由插⼊的节点来指向
                insertNode.next = temp.next;
                //将上⼀个节点的指针域指向要插⼊的节点
                temp.next = insertNode;
                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }

    /**
     * 删除节点
     * @param head
     * @param index
     */
    public static void deleteNode(Node head, int index){
        if (index < 1 || index > linkListLength(head) + 1){
            System.out.println("删除节点有误");
            return;
        }
        Node temp = head;
        int currentPos = 0;
        while (temp.next != null){
            if ((index-1) == currentPos){
                //存储被删除节点
                Node deleteNode = temp.next;
                temp.next = temp.next.next;
                deleteNode.next = null;
                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }

    /**
     * 获取链表的⻓度
     2.5删除节点
     删除某个位置上的节点其实是和插⼊节点很像的， 同样都要找到上⼀个节点。将上⼀个节点的指针域改
     变⼀下，就可以删除了～
     * @param head 头指针
     */
    public static int linkListLength(Node head) {
        int length = 0;
        //临时节点，从⾸节点开始
        Node temp = head.next;
        // 找到尾节点
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}