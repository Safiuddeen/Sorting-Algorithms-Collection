package sortingMethod;

public class QuickSort {

    // This method takes the last element as pivot, places
    // the pivot element at its correct position in the sorted array,
    // and places all smaller elements to the left of the pivot
    // and all greater elements to the right of the pivot
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver program
    public static void main(String[] args) {
        int[] arr = {120, 10, 33, 25, 60, 95};
        int n = arr.length;

        System.out.println("Given Array:");
        printArray(arr);

        sort(arr, 0, n - 1);

        System.out.println("\nSorted array:");
        printArray(arr);
    }
}

