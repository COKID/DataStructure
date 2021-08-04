package Sort;

public class InsertSort {
    public static void sort(int[] array){
        for(int i=1;i<array.length;i++){
            int temp=array[i];
            //把下标保存起来
            int j=i;
            while(j>0&&temp<array[j-1]){
                //上面的数覆盖其下面的数
                array[j]=array[j-1];
                j--;
            }
            array[j]=temp;//插入数据
        }
    }
}
