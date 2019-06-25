package myleetcode;

import java.util.List;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
// Definition for a Node.
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

