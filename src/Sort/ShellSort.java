package Sort;

public class ShellSort {
    public static void sort(int[] array){
        int d=array.length;
        while(true){
            d=d/2;
            for(int x=0;x<d;x++) {
                for(int i=x+d;i<array.length;i=i+d) {
                    int temp=array[i];
                    int j;
                    for(j=i-d;j>=0&&array[j]>temp;j=j-d) {
                        array[j+d]=array[j];
                    }
                    array[j+d]=temp;
                }
            }
            if(d==1) {
                break;
            }
        }
    }
}
