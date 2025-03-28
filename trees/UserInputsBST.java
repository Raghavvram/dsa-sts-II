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

public class UserInputsBST {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of elements in the tree:");
        int n = sc.nextInt();
        
        Node root = null;
        System.out.println("Enter the elements of the tree (no -1 for null nodes needed):");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            root = insertNode(root, data); // Insert each element into the BST
        }
        
        System.out.println("Tree traversal (Pre-order):");
        printTree(root);
    }

    // Method to insert a node into the BST
    public static Node insertNode(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }
        return root;
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
