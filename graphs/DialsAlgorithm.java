import java.util.*;

class DialsAlgorithm {

    static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static void dials(ArrayList<ArrayList<Edge>> al, int v, int max, int sr) {
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[sr] = 0;

        ArrayList<Queue<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < v * max; i++) {
            buckets.add(new LinkedList<>());
        }

        buckets.get(0).add(sr);
        int index = 0;

        while (index < buckets.size()) {
            while (!buckets.get(index).isEmpty()) {
                int u = buckets.get(index).poll();

                for (Edge e : al.get(u)) {
                    if (dis[u] + e.w < dis[e.v]) {
                        dis[e.v] = dis[u] + e.w;
                        buckets.get(dis[e.v]).add(e.v);
                    }
                }
            }
            index++;
        }
        System.out.println(Arrays.toString(dis));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Edge>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            al.get(u).add(new Edge(v, w));
        }

        int max = sc.nextInt();
        dials(al, n, max, 0);
    }
}

