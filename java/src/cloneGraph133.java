import myleetcode.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class cloneGraph133 {

    class Solution {
        HashMap<Node, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null)
                return null;
            if (node.neighbors == null)
                return new Node(node.val, null);

            if (map.containsKey(node))
                return map.get(node);

            Node newnode = new Node(node.val, null);
            newnode.neighbors = new ArrayList<>();
            map.put(node, newnode);
            for (int i = 0; i < node.neighbors.size(); i++) {
                newnode.neighbors.add(cloneGraph(node.neighbors.get(i)));
            }
            return newnode;
        }
    }

    public void run() {
        Solution s = new Solution();
        s.cloneGraph(null);
    }

    public static void main(String[] args) {
        cloneGraph133 p = new cloneGraph133();
        p.run();
    }
}

