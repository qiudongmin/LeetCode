import myleetcode.ListNode;
import myleetcode.TreeNode;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class LinkedListToBST109 {

    class Solution {

        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            if (head.next.next == null) {
                TreeNode root = new TreeNode(head.next.val);
                root.left = new TreeNode(head.val);
                return root;
            }
            ListNode p = head;
            ListNode q = head.next.next;
            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }
            ListNode mid = new ListNode(p.next.val);
            mid.next = p.next.next;
            p.next = null;
            TreeNode root = new TreeNode(mid.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(mid.next);
            return root;
        }
    }

    public void run() {
        Solution s = new Solution();
        ListNode a = new ListNode(-10);
        ListNode b = new ListNode(-3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        s.sortedListToBST(a);
    }

    public static void main(String[] args) {
        LinkedListToBST109 p = new LinkedListToBST109();
        p.run();
    }
}

