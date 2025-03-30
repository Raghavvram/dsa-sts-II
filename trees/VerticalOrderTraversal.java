import java.util.*;

class VerticalOrderTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class QNode {
        Node tnode;
        int vertical;
        int level;

        QNode(Node tnode, int vertical, int level) {
            this.tnode = tnode;
            this.vertical = vertical;
            this.level = level;
        }
    }

    static class BST {
        Node root = null;

        Node create(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }
            if (data < root.data) {
                root.left = create(root.left, data);
            } else {
                root.right = create(root.right, data);
            }
            return root;
        }

        void verticalTraversal(Node root) {
            if (root == null) return;

            TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
            Queue<QNode> queue = new LinkedList<>();
            queue.add(new QNode(root, 0, 0));

            while (!queue.isEmpty()) {
                QNode current = queue.poll();
                int vertical = current.vertical;
                int level = current.level;

                map.putIfAbsent(vertical, new TreeMap<>());
                map.get(vertical).putIfAbsent(level, new ArrayList<>());
                map.get(vertical).get(level).add(current.tnode.data);

                if (current.tnode.left != null) {
                    queue.add(new QNode(current.tnode.left, vertical - 1, level + 1));
                }
                if (current.tnode.right != null) {
                    queue.add(new QNode(current.tnode.right, vertical + 1, level + 1));
                }
            }

            for (TreeMap<Integer, ArrayList<Integer>> levels : map.values()) {
                for (ArrayList<Integer> nodes : levels.values()) {
                    for (int data : nodes) {
                        System.out.print(data + " ");
                    }
                }
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            BST tree = new BST();

            System.out.println("Enter the number of nodes:");
            int n = sc.nextInt();

            System.out.println("Enter the node values:");
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                tree.root = tree.create(tree.root, value);
            }

            System.out.println("Vertical Order Traversal:");
            tree.verticalTraversal(tree.root);
        }
    }
}

