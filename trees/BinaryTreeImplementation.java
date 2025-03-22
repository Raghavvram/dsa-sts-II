import java.util.*;

class BinaryTreeImplementation {

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

    static class BinaryTree {
        private TreeNode root = null;

        public TreeNode buildTree() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter root node data (-1 for null): ");
            int rootData = scanner.nextInt();

            if (rootData == -1) {
                return null;
            }

            root = new TreeNode(rootData);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();
                
                System.out.println("Enter left child of " + currentNode.data + " (-1 for null): ");
                int leftData = scanner.nextInt();
                if (leftData != -1) {
                    TreeNode leftChild = new TreeNode(leftData);
                    currentNode.left = leftChild;
                    queue.add(leftChild);
                }

                System.out.println("Enter right child of " + currentNode.data + " (-1 for null): ");
                int rightData = scanner.nextInt();
                if (rightData != -1) {
                    TreeNode rightChild = new TreeNode(rightData);
                    currentNode.right = rightChild;
                    queue.add(rightChild);
                }
            }

            scanner.close(); // Close the Scanner
            return root;
        }

        public void levelOrderTraversal(TreeNode root) {
            if (root == null) {
                System.out.println("Tree is empty.");
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            System.out.println("Level-order traversal:");
            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.data + " ");

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree();
        binaryTree.levelOrderTraversal(root);
    }
}
