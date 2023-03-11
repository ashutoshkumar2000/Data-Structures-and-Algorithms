/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null){
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        return constructBST(head, null);
    }
    
    public TreeNode constructBST(ListNode leftH, ListNode rightH){
        if(leftH == rightH){
            return null;
        }
        
        ListNode slow = leftH;
        ListNode fast = leftH;
        while(fast != rightH && fast.next != rightH){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = constructBST(leftH, slow);
        root.right = constructBST(slow.next, rightH);
        return root;
    }
}