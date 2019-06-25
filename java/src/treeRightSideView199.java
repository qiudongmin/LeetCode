import myleetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class treeRightSideView199 {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null)
                return new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            dfs(root, res, 0);
            return res;
        }

        private void dfs(TreeNode root, ArrayList<Integer> res, int level) {
            if (root == null)
                return;
            if (res.size() < level + 1)
                res.add(root.val);
            dfs(root.right, res, level + 1);
            dfs(root.left, res, level + 1);
        }
    }

    public void run() {
        Solution s = new Solution();
        s.rightSideView(null);
    }

    public static void main(String[] args) {
        treeRightSideView199 p = new treeRightSideView199();
        p.run();
    }
}

