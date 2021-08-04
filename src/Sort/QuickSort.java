package Sort;

public class QuickSort {
    public static void sort(int[] array,int low, int high){
        int temp;
        if(low<high){
            temp = partition(array,low,high);
            sort(array,low,temp-1);
            sort(array,temp+1,high);
        }
    }
    private static int partition(int[] array,int low,int high){
        int privotkey = array[low];
        while(low<high){
            while(low<high&&array[high]>=privotkey) high --;
            swap(array,low,high);
            while(low<high&&array[low]<=privotkey) low ++;
            swap(array,low,high);
        }
        return low;
    }
    private static void swap(int[] array,int low,int high){
        if(low<high){
            int temp=array[low];
            array[low]=array[high];
            array[high]=array[low];
        }
    }
}
