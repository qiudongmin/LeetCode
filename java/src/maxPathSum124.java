import myleetcode.TreeNode;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class maxPathSum124 {

    class Solution {
        public int max;

        public int maxPathSum(TreeNode root) {
            max = Integer.MIN_VALUE;
            if (root == null) { return 0; }
            if (root.left == null && root.right == null) { return root.val; }
            path(root);
            return max;
        }

        private int path(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, path(root.left));
            int right = Math.max(0, path(root.right));
            max = Math.max(max, root.val + left + right);
            return Math.max(left, right) + root.val;
        }
    }

    public void run() {
        Solution s = new Solution();
        s.maxPathSum(null);
    }

    public static void main(String[] args) {
        maxPathSum124 p = new maxPathSum124();
        p.run();
    }
}

