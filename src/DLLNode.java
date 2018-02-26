/**
 * 双向链表
 */
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }
    static int DLLLength(DLLNode headNode){
        int length=0;
        DLLNode currentNode=headNode;
        while (currentNode!=null){
            length++;
            currentNode=currentNode.next;
        }
        return length;
    }
    static DLLNode insertNode(DLLNode headNode,DLLNode nodeToInsert,int position){
        if(headNode==null)return nodeToInsert;
        int size=DLLLength(headNode);
        if(position>size+1||position<1){
            System.out.println("Position of node to insert is invalid.The valid inputs are 1 to"+(size+1));
            return headNode;
        }
        if (position==1){//在链表开头插入
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        }else {//中间或者末尾插入
            DLLNode previousNode=headNode;
            int count=1;
            while (count<position-1){
                previousNode=previousNode.getNext();
                count++;
            }
            DLLNode currentNode=previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if(currentNode!=null){
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }
    static DLLNode deleteNode(DLLNode headNode,int position){
        int size=DLLLength(headNode);
        //如果被删除的位置不在链表长度范围内，报错并返回
        if(position>size||position<1){
            System.out.println("Position of node to insert is invalid.The valid inputs are 1 to"+size);
            return headNode;
        }
        if (position==1){
            DLLNode currentNode=headNode.getNext();
            headNode=null;
            currentNode.setPrevious(null);
            return currentNode;
        }else {
            DLLNode previousNode=headNode;
            int count=1;
            while (count<position-1){
                previousNode=previousNode.getNext();
                count++;
            }
            DLLNode currentNode=previousNode.getNext();
            DLLNode laterNode=currentNode.getNext();
            previousNode.setNext(laterNode);
            if (laterNode!=null){
                //如果被删除的结点的后继不是null结点，那么设置其前驱指针指向被删除结点的前驱结点
                laterNode.setPrevious(previousNode);
                currentNode=null;
            }
            return headNode;
        }
    }

}
