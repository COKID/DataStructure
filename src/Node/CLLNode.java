package Node;

/**
 * 循环链表
 */
public class CLLNode {
    private int data;
    private CLLNode next;


    public CLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }

    static int CircleListLength(CLLNode headNode){
        int length=0;
        CLLNode currentNode=headNode;
        while (currentNode!=null){
            length++;
            currentNode=currentNode.next;
            if(currentNode==headNode)break;
        }
        return length;
    }
    static CLLNode insertNode(CLLNode headNode, CLLNode nodeToInsert, int position){
        if(headNode==null)return nodeToInsert;
        int size=CircleListLength(headNode);
        if(position>size+1||position<1){
            System.out.println("Position of node to insert is invalid.The valid inputs are 1 to"+(size+1));
            return headNode;
        }
        if (position==1){//在链表开头插入
            return InsertAtBeginInCLL(headNode,nodeToInsert);
        }else if(position==size){//或者末尾插入
            return InsertAtEndInCLL(headNode,nodeToInsert);
        }else {//中间
            CLLNode previousNode=headNode;
            int count=1;
            while (count<position-1){
                previousNode=previousNode.getNext();
                count++;
            }
            CLLNode currentNode=previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }
    //在末尾插入
    static CLLNode InsertAtEndInCLL(CLLNode headNode,CLLNode nodeToInsert){
        CLLNode currentNode=headNode;
        while(currentNode.getNext()!=headNode){
            currentNode=currentNode.getNext();
        }
        nodeToInsert.setNext(nodeToInsert);
        if(headNode==null){
            headNode=nodeToInsert;
        }else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
        return headNode;
    }
    //在开头插入
    static CLLNode InsertAtBeginInCLL(CLLNode headNode,CLLNode nodeToInsert){
        CLLNode currentNode=headNode;
        while (currentNode.getNext()!=headNode){
            currentNode=currentNode.getNext();
        }
        nodeToInsert.setNext(nodeToInsert);
        if(headNode==null){
            headNode=nodeToInsert;
        }else{
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
            headNode=nodeToInsert;
        }
        return headNode;
    }
    static CLLNode deleteNode(CLLNode headNode, int position){
        int size=CircleListLength(headNode);
        //如果被删除的位置不在链表长度范围内，报错并返回
        if(position>size||position<1){
            System.out.println("Position of node to insert is invalid.The valid inputs are 1 to"+size);
            return headNode;
        }
        if (position==1){
            return DeleteFrontNodeFromCLL(headNode);
        }else if(position==size){
            return DeleteLastNodeFromCLL(headNode);
        } else{
            //删除中间
            CLLNode previousNode=headNode;
            int count=1;
            while (count<position-1){
                previousNode=previousNode.getNext();
                count++;
            }
            CLLNode currentNode=previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode=null;
        }
        return headNode;
    }
    //删除最后
    static CLLNode DeleteLastNodeFromCLL(CLLNode head){
        CLLNode temp=head;
        CLLNode currentNode=head;
        if (head==null){
            System.out.println("List Empty");
            return head;
        }
        while (currentNode.getNext()!=head){
            temp=currentNode;
            currentNode=currentNode.getNext();
        }
        temp.setNext(head);
        currentNode=null;
        return head;
    }
    //删除第一
    static CLLNode DeleteFrontNodeFromCLL(CLLNode head){
        CLLNode temp=head;
        CLLNode currentNode=head;
        if (head==null){
            System.out.println("List Empty");
            return head;
        }
        while (currentNode.getNext()!=head){
            currentNode=currentNode.getNext();
        }
        currentNode.setNext(head.getNext());
        head=head.getNext();
        temp=null;
        return head;
    }
    static void PrintCircularListData(CLLNode headNode){
        CLLNode cllNode=headNode;
        while (cllNode!=null){
            System.out.println(cllNode.getData()+"->");
            cllNode=cllNode.getNext();
            if (cllNode==headNode)break;
        }
        System.out.println("("+cllNode.getData()+")headNode");
    }
}
