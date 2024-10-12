package Interview.Algorithms.Sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 6, 7, 8, 9, 0};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void sort(int[] arr) {
        int min=arr[0];
        int index=0;
        for (int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j < arr.length; j++) {
               if(arr[i] > arr[j]) {
                   min = arr[j];
                   index=j;
               }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
    }
}
