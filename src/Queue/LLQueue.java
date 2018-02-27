package Queue;

import Node.ListNode;

import java.util.EmptyStackException;

/**
 * 链表实现的队列
 */

public class LLQueue {
    private ListNode frontNode;
    private ListNode rearNode;
    private LLQueue(){
        this.frontNode=null;
        this.rearNode=null;
    }
    public static LLQueue createQueue(){
        return new LLQueue();
    }
    public boolean isEmpty(){
        return (frontNode==null);
    }
    public void enQueue(int data){
        ListNode newNode=new ListNode(data);
        if(rearNode!=null){
            rearNode.setNext(newNode);
        }
        rearNode=newNode;
        if(frontNode==null){
            frontNode=rearNode;
        }
    }
    public int deQueue(){
        int data;
        if(isEmpty()){
            throw new EmptyStackException();
        }else {
            data=frontNode.getData();
            frontNode=frontNode.getNext();
        }
        return data;
    }
}
