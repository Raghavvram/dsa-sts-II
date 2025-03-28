import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class UserInputsTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of elements in the tree:");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the tree (-1 for null nodes):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Node root = buildTree(arr, n, 0);
        System.out.println("Tree traversal:");
        printTree(root);
    }

    // Method to build the binary tree
    public static Node buildTree(int[] arr, int n, int i) {
        if (i >= n || arr[i] == -1) {
            return null;
        }

        Node node = new Node(arr[i]);
        node.left = buildTree(arr, n, 2 * i + 1);
        node.right = buildTree(arr, n, 2 * i + 2);

        return node;
    }

    // Method to print the binary tree (Pre-order traversal)
    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
