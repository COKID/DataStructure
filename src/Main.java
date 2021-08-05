import Sort.HeapSort;
import Sort.InsertSort;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {0, 20, 25, 15, 42, 36, 16, 12};
        int[] array2 = {0, 1, 5, 3, 2, 6, 7, 9, 13, 54, 20};
        int[] array3 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] array = array2;

        HeapSort.sort(array, array.length - 1);
        for (int value : array) {
            System.out.println(value);
        }
    }

}
