package Sort;

public class HeapSort {
    public static void sort(int[] array,int n) {//数组0号位不用,n为除0号位的元素数量。
        for(int i=n/2; i>=1; i--){
            heapAdjust(array,i,n);//从最后一个有子节点的节点开始依次往前调整对应节点来生成大顶堆
        }
        for(int i=1; i<n; i++){
            swap(array,1,n-i+1);//交换堆顶元素与未排序堆最后一个元素
            heapAdjust(array,1,n-i);//根据调整节点重新生成大顶堆
        }
    }
    private static void heapAdjust(int[] r, int k, int m ) {
        //要筛选结点的编号为k，堆中最后一个结点的编号为m
        int i = k;
        int j = 2 * i;//到达下一层的左孩子
        while (j <= m) {           //筛选还没有进行到叶子
            if (j < m && r[j] < r[j + 1]) j++;  //左右孩子中取较大者
            if (r[i] > r[j]) break;
            else {
                swap(r, i, j);
                i = j;
                j = 2 * i;
            }
        }
    }
    private static void swap(int[] array,int low,int high){
        if(low<high){
            int temp=array[low];
            array[low]=array[high];
            array[high]=temp;
        }
    }
}
