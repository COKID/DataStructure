package Sort;

public class CountSort {
    public static int[] sort(int[] array){
        int[] b = new int[array.length];
        int max = array[0],min = array[0];
        for(int i:array){
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }
        int k=max-min+1;//这里k的大小是要排序的数组中，元素大小的极值差+1
        int[] c =new int[k];
        for (int j : array) {//O(n)
            c[j - min] += 1;//优化过的地方，减小了数组c的大小
        }
        for(int i=1;i<c.length;++i){//O(k)
            c[i]=c[i]+c[i-1];
        }
        for(int i=array.length-1;i>=0;--i){//O(n)
            b[--c[array[i]-min]]=array[i];//按存取的方式取出c的元素
        }
        return b;
    }
}
