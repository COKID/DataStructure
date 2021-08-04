package Sort;

public class MergeSort {
    public static int[] sort(int[] array,int m,int n){
        int mid;
        int[] result = new int[array.length];
        if(array.length == 1|| m==n){
            result[0] = array[0];
        }else{
            mid = (m+n)/2;
            int[] temp1 = new int[mid-m+1];
            int[] temp2 = new int[array.length-mid+m-1];
            System.arraycopy(array,0,temp1,0,mid-m+1);
            System.arraycopy(array,mid-m+1,temp2,0,array.length-mid+m-1);
            int[] result1 = sort(temp1,m,mid);
            int[] result2 = sort(temp2,mid+1,n);
            result = Merge(result1,result2);
        }
        return result;
    }
    private static int[] Merge(int[] i,int[] j){
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
}
