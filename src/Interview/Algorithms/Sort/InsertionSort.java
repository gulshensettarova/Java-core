package Interview.Algorithms.Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 14, 5, 16, 7, 18, 9 };
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    public static  void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j>=0 && key<arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

    }
}
