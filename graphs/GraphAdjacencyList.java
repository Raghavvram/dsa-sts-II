
import java.util.ArrayList;
import java.util.Scanner;

class GraphAdjacencyList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        if (vertices <= 0) {
            System.out.println("The number of vertices must be greater than zero.");
            return;
        }

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        if (edges < 0) {
            System.out.println("The number of edges cannot be negative.");
            return;
        }

        // Initialize the adjacency list
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (source and destination): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();

            if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
                System.out.println("Invalid edge. Source and destination must be between 0 and " + (vertices - 1) + ".");
                i--; // Prompt the user again for a valid edge
                continue;
            }

            // Add the edge to the adjacency list
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source); // For undirected graphs
        }

        // Print the adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " : ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
