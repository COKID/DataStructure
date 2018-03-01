package Sort;

public class Sort {
    void BubbleSort(){
        int [] array={1,5,3,2,6,7,9,13,54,20};
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
    void BubbleSortImproved(){
        int [] array={1,5,3,2,6,7,9,13,54,20};
        boolean swapped=true;
        for(int i=0;i<array.length-1&&swapped;i++){
            swapped=false;
            //每一轮比较的次数为N-1-i;
            for(int j=0;j<array.length-1-i;j++){
                //比较相邻的两个数,小靠前
                if(array[j]>array[j+1]){
                    //两个数做交换.通过设置临时变量
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    swapped=true;
                }
            }
        }
    }
    void InsertSort(){
        int [] array={20,25,15,42,36,16,12};
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
    void SelectSort(){
        int [] array={1,5,3,2,6,7,9,13,54,20};
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
    void ShellSort(){
        int[]a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        int d=a.length;
        while(true){
            d=d/2;
            for(int x=0;x<d;x++) {
                for(int i=x+d;i<a.length;i=i+d) {
                    int temp=a[i];
                    int j;
                    for(j=i-d;j>=0&&a[j]>temp;j=j-d) {
                        a[j+d]=a[j];
                    }
                    a[j+d]=temp;
                }
            }
            if(d==1) {
                break;
            }
        }
    }
    int[] sort(int[] o,int m,int n){
        int mid;
        int[] result = new int[o.length];
        if(o.length == 1|| m==n){
            result[0] = o[0];
        }else{
            mid = (m+n)/2;
            int[] temp1 = new int[mid-m+1];
            int[] temp2 = new int[o.length-mid+m-1];
            System.arraycopy(o,0,temp1,0,mid-m+1);
            System.arraycopy(o,mid-m+1,temp2,0,o.length-mid+m-1);
            int[] result1 = sort(temp1,m,mid);
            int[] result2 = sort(temp2,mid+1,n);
            result = Merge(result1,result2);
        }
        return result;
    }

    int[] Merge(int[] i,int[] j){
        int m=0,n=0,k=0;
        int[] result = new int[i.length+j.length];

        for(; m<i.length&&n<j.length; k++){
            if(i[m]<j[n]){
                result[k] = i[m++];
            }else{
                result[k] = j[n++];
            }
        }

        if(m<i.length){
            while(m<i.length){
                result[k++] = i[m++];
            }
        }

        if(n<j.length){
            while(n<j.length){
                result[k++] = j[n++];
            }
        }
        return result;
    }


    void Quicksort(int[] a,int low,int high){
        int temp;
        if(low<high){
            temp = partition(a,low,high);
            Quicksort(a,low,temp-1);
            Quicksort(a,temp+1,high);
        }
    }

    int partition(int[] a,int low,int high){
        int privotkey = a[low];
        while(low<high){
            while(low<high&&a[high]>=privotkey) high --;
            swap(a,low,high);
            while(low<high&&a[low]<=privotkey) low ++;
            swap(a,low,high);
        }
        return low;
    }
    void swap(int[] a,int low,int high){
        if(low<high){
            int temp=a[low];
            a[low]=a[high];
            a[high]=a[low];
        }
    }
    void HeapSort(int[] a,int n){
        for(int i=n/2; i>=1; i--){
            heapAdjust(a,i,n);//从最后一个有子节点的节点开始依次往前调整对应节点来生成大顶堆
        }
        for(int i=1; i<n; i++){
            swap(a,1,n-i-1);//交换堆顶元素与未排序堆最后一个元素
            heapAdjust(a,1,n-i);//根据调整节点重新生成大顶堆
        }
}
    void heapAdjust(int r[], int k, int m ){
        //要筛选结点的编号为k，堆中最后一个结点的编号为m
        int i=k;
        int  j=2*i;//到达下一层的左孩子
        while (j<=m ){           //筛选还没有进行到叶子
            if (j<m && r[j]<r[j+1]) j++;  //左右孩子中取较大者
            if (r[i]>r[j]) break;
            else {
                swap(r,i,j);
                i=j;
                j=2*i;
            }
        }

    }
}
