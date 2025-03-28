import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class MaxHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    void insert(int d) {
        heap.add(d);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    int extractMax() {
        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return max;
    }

    void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxHeap maxHeap = new MaxHeap();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            maxHeap.insert(sc.nextInt());
        }

        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[i] = maxHeap.extractMax();
        }
        System.out.println(Arrays.toString(sorted));
    }
}
