package Stack;

import Node.ListNode;

import java.util.EmptyStackException;
import java.util.concurrent.Executors;

public class LLStack {
    private ListNode headNode;
    public LLStack(){
        this.headNode=null;
    }
    public void Push(int data){
        if(headNode==null){
            headNode=new ListNode(data);
        }else{
            ListNode listNode=new ListNode(data);
            listNode.setNext(headNode);
            headNode=listNode;
        }
    }
    public int top(){
        if(headNode==null){
            throw new EmptyStackException();
        }else{
            return headNode.getData();
        }
    }
    public int pop(){
        if (headNode==null){
            throw new EmptyStackException();
        }else{
            int data =headNode.getData();
            headNode=headNode.getNext();
            return data;
        }
    }
    public boolean isEmpty(){
        if(headNode==null)return true;
        else return false;
    }
    public void deleteStack(){
        headNode=null;
    }
}
