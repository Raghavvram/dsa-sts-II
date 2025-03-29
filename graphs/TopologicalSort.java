import java.util.*;

class TopologicalSort {
    static void kahnTopologicalSort(ArrayList<ArrayList<Integer>> al, int v) {
        int[] inDegree = new int[v];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> topoSort = new ArrayList<>();

        // Calculate in-degrees of all vertices
        for (int i = 0; i < v; i++) {
            for (int adj : al.get(i)) {
                inDegree[adj]++;
            }
        }

        // Add vertices with 0 in-degree to the queue
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process vertices in queue
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoSort.add(curr);

            for (int adj : al.get(curr)) {
                inDegree[adj]--;
                if (inDegree[adj] == 0) {
                    queue.add(adj);
                }
            }
        }

        // Check if the graph has a cycle
        if (topoSort.size() != v) {
            System.out.println("The graph contains a cycle and cannot be topologically sorted.");
        } else {
            for (int node : topoSort) {
                System.out.print(node + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            al.get(s).add(d);
        }

        kahnTopologicalSort(al, v);
    }
}

