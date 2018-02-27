package Node;

/**
 * 单向链表
 */
public class ListNode {
    private int data;
    private ListNode next;
    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    static int ListLength(ListNode headNode){
        int length=0;
        ListNode currentNode=headNode;
        while (currentNode!=null){
            length++;
            currentNode=currentNode.next;
        }
        return length;
    }
    static ListNode InsertNode(ListNode headNode,ListNode nodeToInsert,int position){
         if(headNode==null)return nodeToInsert;//若链表为空，插入
         int size =ListLength(headNode);
         if(position>size+1||position<1){
             System.out.println("Position of node to insert is invalid.The valid inputs are 1 to"+(size+1));
             return headNode;
         }
         if(position==1){//在链表开头插入
             nodeToInsert.setNext(headNode);
             return nodeToInsert;
         }else {
             //在链表中间或末尾插入
             ListNode previousNode=headNode;
             int count=1;
             while (count<position-1){
                 previousNode=previousNode.getNext();
                 count++;
             }
             ListNode currentNode=previousNode.getNext();
             nodeToInsert.setNext(currentNode);
             previousNode.setNext(nodeToInsert);
         }
        return headNode;
    }
    static ListNode DeleteNode(ListNode headNode,int position){
        int size =ListLength(headNode);
        if(position>size||position<1){
            System.out.println("Position of node to delete is invalid. The valid inputs are to"+size);
            return headNode;
        }
        if(position==1){//删除单向链表的表头结点
            ListNode currentNode = headNode.getNext();
            headNode=null;
            return currentNode;
        }else {
            //删除中间或者表尾结点
            ListNode previousNode=headNode;
            int count=1;
            while (count<position-1){
                previousNode=previousNode.getNext();
                count++;
            }
            ListNode currentNode=previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode=null;
        }
        return headNode;
    }
    static void DeleteLinkedList(ListNode head){
        ListNode auxilaryNode,iterator=head;
        while (iterator!=null){
            auxilaryNode=iterator.next;
            iterator=null;//在java中垃圾回收器将自动处理
            iterator=auxilaryNode;
        }
    }
}
