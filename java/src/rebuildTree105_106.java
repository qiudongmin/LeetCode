import myleetcode.TreeNode;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class rebuildTree105_106 {

    class Solution {
        public TreeNode buildTree105(int[] preorder, int[] inorder) {
            if(preorder == null || inorder == null)
                return null;
            if(preorder.length == 0 || inorder.length == 0)
                return null;
            return construct105(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        }

        private TreeNode construct105(int[] preorder, int[]inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
            if (preBegin > preEnd || inBegin > inEnd) {
                return null;
            }
            int rootVal = preorder[preBegin];
            TreeNode root = new TreeNode(rootVal);
            if (preBegin == preEnd && inBegin == inEnd && preorder[preBegin] == inorder[inBegin]) {
                return root;
            }
            int inRoot = inBegin;
            while (inRoot <= inEnd && inorder[inRoot] != rootVal) {
                inRoot++;
            }
            int leftLength = inRoot - inBegin;
            int rightLength = inEnd - inRoot;
            if (leftLength > 0) {
                root.left = construct105(preorder, inorder, preBegin+1, preBegin+leftLength, inBegin,inRoot-1);
            }
            if (rightLength > 0) {
                root.right = construct105(preorder, inorder, preBegin+leftLength+1, preEnd, inRoot+1, inEnd);
            }

            return root;
        }

        public TreeNode buildTree106(int[] inorder, int[] postorder) {
            if(inorder == null || postorder == null)
                return null;
            if(inorder.length == 0 || postorder.length == 0)
                return null;
            return construct106(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        }

        private TreeNode construct106(int[] inorder, int[] postorder, int inBegin, int inEnd, int postBegin, int postEnd) {
            if (inBegin > inEnd || postBegin > postEnd) {
                return null;
            }
            int rootVal = postorder[postEnd];
            TreeNode root = new TreeNode(rootVal);
            if (inBegin == inEnd && postBegin == postEnd && inorder[inEnd] == postorder[postEnd]) {
                return root;
            }
            int inRoot = inBegin;
            while (inRoot <= inEnd && inorder[inRoot] != rootVal) {
                inRoot++;
            }
            int leftLength = inRoot - inBegin;
            int rightLength = inEnd - inRoot;
            if (leftLength > 0) {
                root.left = construct106(inorder, postorder, inBegin, inRoot - 1, postBegin, postBegin + leftLength - 1);
            }
            if (rightLength > 0) {
                root.right = construct106(inorder, postorder, inRoot + 1, inEnd, postBegin + leftLength, postEnd - 1);
            }

            return root;
        }
    }

    public void run() {
        Solution s = new Solution();
        int[] a = {9,3,15,20,7};
        int[] b = {9,15,7,20,3};
        s.buildTree106(a, b);
    }

    public static void main(String[] args) {
        rebuildTree105_106 p = new rebuildTree105_106();
        p.run();
    }
}

