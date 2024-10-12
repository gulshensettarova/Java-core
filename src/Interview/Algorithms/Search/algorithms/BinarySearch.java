package Interview.Algorithms.Search.algorithms;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        //Qeyd: Yalnız sıralanmış siyahılarda tədbiq oluna bilir
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        Scanner sc = new Scanner(System.in);
        int key=sc.nextInt();
        if(search(arr,key)!=-1) System.out.println("Search result is: "+search(arr,key));
        else System.out.println("Key is not found");

    }
    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid_index = 0;
        while (low <= high) {
            mid_index = (low + high) / 2;
            if(key==arr[mid_index]){
                return arr[mid_index];
            }
            else if(arr[mid_index]>key){
                high=mid_index-1;
            }
            else if(arr[mid_index]<key){
                low=mid_index+1;
            }

        }
        return -1;
    }
}
