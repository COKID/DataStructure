package Sort;

public class BucketSort {
    static int BUCKET=10;
    public static void sort(int[] array, int array_size){
        int[] bucket=new int[BUCKET];
        for(int i=0;i<BUCKET;i++)bucket[i]=0;
        for(int i=0;i<array_size;i++)++bucket[array[i]];
        for(int i=0,j=0;j<BUCKET;j++){
            for(int k=bucket[j];k>0;--k){
                array[i++]=j;
            }
        }
    }
}
