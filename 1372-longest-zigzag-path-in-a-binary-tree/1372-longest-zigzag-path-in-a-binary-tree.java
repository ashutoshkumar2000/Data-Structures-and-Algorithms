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
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        
        int res[] = helper(root);
        return res[2];
    }
    
    public int[] helper(TreeNode node){
        if(node == null) return new int[]{-1, -1, -1};
        
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        
        int zigZagMax = Math.max(Math.max(left[1], right[0]) + 1, Math.max(left[2], right[2]));
        return new int[]{left[1]+1, right[0]+1, zigZagMax};
    }
}