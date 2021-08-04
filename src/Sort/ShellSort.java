package Sort;

public class ShellSort {
    public static void sort(int[] array){
        int d=array.length;
        while(d>1){
            d=d/2;
            for(int x=0;x<d;x++) {
                for(int i=x+d;i<array.length;i=i+d) {
                    int temp=array[i];
                    int j=i;
                    while(j>0&&temp<array[j-d]) {
                        array[j]=array[j-d];
                        j-=d;
                    }
                    array[j]=temp;
                }
            }
        }
    }
}
