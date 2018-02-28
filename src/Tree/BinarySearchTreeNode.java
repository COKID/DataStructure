package Tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTreeNode {
    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }
    static BinarySearchTreeNode Find(BinarySearchTreeNode root,int data){
        while (root!=null){
            if(data==root.getData())return root;
            else if(data>root.getData())root=root.getRight();
            else root=root.getLeft();
        }
        return null;
    }
    static BinarySearchTreeNode FindMin(BinarySearchTreeNode root){
        if(root==null)return null;
        else if(root.getLeft()==null)return root;
        else return FindMin(root.getLeft());
    }
    static BinarySearchTreeNode FindMax(BinarySearchTreeNode root){
        if(root==null)return null;
        else if(root.getRight()==null)return root;
        else return FindMax(root.getRight());
    }
    static BinarySearchTreeNode Delete(BinarySearchTreeNode root,int data){
        BinarySearchTreeNode temp;
        if(root==null) System.out.println("Element not there in tree");
        else if(data<root.data)
            root.left=Delete(root.getLeft(),data);
        else if(data>root.data)
            root.right=Delete(root.getRight(),data);
        else {
            if(root.getLeft()!=null&&root.getRight()!=null){
                temp=FindMax(root.getLeft());
                root.setData(temp.data);
                root.left=Delete(root.getLeft(),root.getData());
            }else{
                if(root.getLeft()==null)root=root.getRight();
                if (root.getRight()==null)root=root.getLeft();
            }
        }
        return root;
    }
}
