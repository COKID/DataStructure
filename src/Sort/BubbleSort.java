package Sort;

public class BubbleSort {
    public static void sort(int[] array){
        for(int i=0;i<array.length-1;i++){
            //每一轮比较的次数为N-1-i;
            for(int j=0;j<array.length-1-i;j++){
                //比较相邻的两个数,小靠前
                if(array[j]>array[j+1]){
                    //两个数做交换.通过设置临时变量
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
}
