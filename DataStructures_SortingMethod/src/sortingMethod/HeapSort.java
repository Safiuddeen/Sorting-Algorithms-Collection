package sortingMethod;

import java.util.Arrays;

public class HeapSort {

    // MaxHeap class as implemented earlier
    public static class MaxHeap {
        private int[] heap;
        private int size;

        public MaxHeap(int[] array) {
            this.heap = array;
            this.size = array.length;
            buildMaxHeap();
        }

        // Build a max heap from the input array
        private void buildMaxHeap() {
            for (int i = (size / 2) - 1; i >= 0; i--) {
                maxHeapify(i);
            }
        }

        // Heapify a subtree rooted with node i
        private void maxHeapify(int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != i) {
                swap(i, largest);
                maxHeapify(largest);
            }
        }

        // Swap two elements in the array
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // Perform heap sort
        public void heapSort() {
            // Temporary size variable to manage heap size during sort
            int originalSize = size;

            for (int i = size - 1; i > 0; i--) {
                // Swap the root (maximum element) with the last element
                swap(0, i);
                // Reduce the heap size
                size--;
                // Restore the heap property for the reduced heap
                maxHeapify(0);
            }

            // Restore the original size
            size = originalSize;
        }
    }

    public static void main(String[] args) {
        int[] array = {15, 20, 10, 30, 60, 50, 40};

        MaxHeap maxHeap = new MaxHeap(array);

        System.out.println("Array before sorting: " + Arrays.toString(array));
        
        maxHeap.heapSort();
        
        System.out.println("Array after heap sort: " + Arrays.toString(array));
    }
}
