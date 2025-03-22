import java.util.*;

public class BinarySearchTreeImplementation {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        TreeNode root;

        public TreeNode insert(TreeNode root, int value) {
            if (root == null) {
                return new TreeNode(value);
            }
            if (value < root.data) {
                root.left = insert(root.left, value);
            } else if (value > root.data) {
                root.right = insert(root.right, value);
            }
            return root;
        }

        public void preOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public void postOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        public void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Enter the number of nodes to be inserted into the BST:");
        int numberOfNodes = scanner.nextInt();

        if (numberOfNodes <= 0) {
            System.out.println("Invalid input. The BST will remain empty.");
            scanner.close();
            return;
        }

        System.out.println("Enter the values one by one:");
        for (int i = 0; i < numberOfNodes; i++) {
            int value = scanner.nextInt();
            bst.root = bst.insert(bst.root, value);
        }

        System.out.println("Pre-order Traversal:");
        bst.preOrderTraversal(bst.root);
        System.out.println();

        System.out.println("Post-order Traversal:");
        bst.postOrderTraversal(bst.root);
        System.out.println();

        System.out.println("In-order Traversal:");
        bst.inOrderTraversal(bst.root);
        System.out.println();

        scanner.close();
    }
}
