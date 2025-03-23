package graphs;

import java.util.Scanner;

class GraphAdjacencyMatrix {

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

        int[][] adjacencyMatrix = new int[vertices][vertices];

        System.out.println("Enter the edges (source and destination): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();

            if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
                System.out.println("Invalid edge. Source and destination must be between 0 and " + (vertices - 1) + ".");
                i--; // Prompt the user again for a valid edge
                continue;
            }

            // Add the edge to the adjacency matrix
            adjacencyMatrix[source][destination] = 1;
            adjacencyMatrix[destination][source] = 1; // For undirected graphs
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
