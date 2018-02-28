package Tree;

import Queue.LLQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
    static void PreOrder(BinaryTreeNode root){
        if(root!=null){
            System.out.println(root.getData());
            PreOrder(root.getLeft());
            PreOrder(root.getRight());
        }
    }
    static void InOrder(BinaryTreeNode root){
        if(root!=null){
            InOrder(root.getLeft());
            System.out.println(root.getData());
            InOrder(root.getRight());
        }
    }
    static void PostOrder(BinaryTreeNode root){
        if(root!=null){
            PostOrder(root.getLeft());
            PostOrder(root.getRight());
            System.out.println(root.getData());
        }
    }
    static void LevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        PriorityQueue<BinaryTreeNode> Q=new PriorityQueue();
        if(root==null)return;
        Q.add(root);
        while (!Q.isEmpty()){
            temp=Q.poll();
            System.out.println(temp.getData());
            if(temp.getLeft()!=null) Q.add(temp.getLeft());
            if(temp.getRight()!=null) Q.add(temp.getRight());
        }
        Q.clear();
    }
}
