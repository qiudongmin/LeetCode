import myleetcode.TreeNode;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class binaryTreeToList114 {

    class Solution {

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                flatten(root.left);
            }
            if (root.right != null) {
                flatten(root.right);
            }
            TreeNode tmp = root.left;
            root.left = null;
            if (tmp != null) {
                TreeNode tr = tmp;
                while (tr.right != null) {
                    tr = tr.right;
                }
                tr.right = root.right;
                root.right = tmp;
            }
        }
    }

    public void run() {
        Solution s = new Solution();
        s.flatten(null);
    }

    public static void main(String[] args) {
        binaryTreeToList114 p = new binaryTreeToList114();
        p.run();
    }
}
