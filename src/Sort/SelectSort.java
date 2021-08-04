package Sort;

public class SelectSort {
    public static void sort(int[] array){
        int min=0;//保存最元素值的下标
        for(int i=0;i<array.length-1;i++){
            min=i;
            //查找最小数在数组中的下标
            for(int j=i+1;j<array.length;j++){
                if(array[min]>array[j]){
                    min=j;//保存最小数的下标
                }
            }
            //如果第i个最小的数位置不在i上,则进行交换
            if(i!=min){
                int temp=array[i];
                array[i]=array[min];
                array[min]=temp;
            }
        }
    }
}
