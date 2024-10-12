package Interview.Algorithms.Sort;

public class QuickSort {


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Rekursiv olaraq sol və sağ hissələr sıralanır
            quickSort(arr, low, pi - 1);  // Sol tərəf
            quickSort(arr, pi + 1, high); // Sağ tərəf
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Pivot olaraq son elementi seçirik
        int pivot = arr[high];
        int i = (low - 1); // Pivotdan kiçik elementləri saxlamaq üçün index

        for (int j = low; j < high; j++) {
            // Pivotdan kiçik olan elementlər tapılır
            if (arr[j] < pivot) {
                i++;

                // Elementləri dəyişirik
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Pivotun yerini dəyişmək
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Pivotun düzgün yerləşdiyi index qaytarılır
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 2};

        // Quick Sort çağırılır
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
