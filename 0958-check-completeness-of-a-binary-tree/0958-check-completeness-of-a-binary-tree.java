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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while(que.peek() != null){
            TreeNode node = que.poll();
            que.offer(node.left);
            que.offer(node.right);
        }
        while(!que.isEmpty() && que.peek() == null)
            que.poll();
        
        return que.isEmpty();
    }
}