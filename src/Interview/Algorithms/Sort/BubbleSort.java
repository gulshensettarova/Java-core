package Interview.Algorithms.Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 13, 8, 5, 16, 2, 8, 10 };
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void sort(int[] arr) {
        boolean swapped;
        for(int i = 0; i < arr.length - 1; i++) {
            swapped = false;
           for(int j = 0; j < arr.length - i - 1; j++) {
               if(arr[j] > arr[j+1]) {
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                   swapped = true;
               }
           }
            if(!swapped) break;

        }
    }
}
