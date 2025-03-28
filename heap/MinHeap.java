import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class MinHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    void insert(int d) {
        heap.add(d);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
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

    int extractMin() {
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return min;
    }

    void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinHeap minHeap = new MinHeap();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            minHeap.insert(sc.nextInt());
        }

        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = minHeap.extractMin();
        }
        System.out.println(Arrays.toString(sorted));
    }
}
