import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class connectNextNode116_117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Queue<Node> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    if (queue.isEmpty())
                        node.next = null;
                    else
                        node.next = queue.peek();
                    if (node.left != null)
                        temp.offer(node.left);
                    if (node.right != null)
                        temp.offer(node.right);
                }
                queue = temp;
            }
            return root;
        }

        public Node connect116(Node root) {
            if (root == null || root.left == null)
                return root;
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect116(root.right);
            connect116(root.left);
            return root;
        }

        public Node connect117(Node root) {
            if (root == null)
                return root;
            if (root.left != null) {
                if (root.right != null) {
                    root.left.next = root.right;
                } else {
                    root.left.next = getNextNode(root.next);
                }
            }
            if (root.right != null) {
                root.right.next = getNextNode(root.next);
            }
            connect117(root.right);
            connect117(root.left);
            return root;
        }

        private Node getNextNode(Node node) {
            while (node != null) {
                if (node.left != null)
                    return node.left;
                if (node.right != null)
                    return node.right;
                node = node.next;
            }
            return null;
        }
    }

    public void run() {
        Solution s = new Solution();
        Node a = new Node(1, null, null,null);
        Node b = new Node(2, null, null,null);
        Node c = new Node(3, null, null,null);
        Node d = new Node(4, null, null,null);
        Node e = new Node(5, null, null,null);
        Node f = new Node(6, null, null,null);
        Node g = new Node(7, null, null,null);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        s.connect(a);
    }

    public static void main(String[] args) {
        connectNextNode116_117 p = new connectNextNode116_117();
        p.run();
    }
}
