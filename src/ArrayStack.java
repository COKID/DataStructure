public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    public ArrayStack(){
        top=-1;
        capacity=1;
        array=new int[capacity];
    }
    public boolean isEmpty(){
        return (top==-1);
    }
    public boolean isStackFull(){
        return (top==capacity-1);
    }
    public void push(int data){
        if(isStackFull()) System.out.println("Stack Overflow");
        else array[++top]=data;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return 0;
        }else{
            return array[top--];
        }
    }
    public void deleteStack(){
        top=-1;
    }
}
