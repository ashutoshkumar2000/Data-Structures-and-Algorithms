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
    class Pair{
        boolean ok;
        int h;
        Pair(int h, boolean ok){
            this.h = h;
            this.ok = ok;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root).ok;
        
    }
    public Pair helper(TreeNode node){
        if(node == null){
            return new Pair(0, true);
        }
        Pair left = helper(node.left);
        if(left.ok == false){
            return new Pair(0, false);
        }
        Pair right = helper(node.right);
        if(right.ok == false || Math.abs(left.h - right.h) > 1){
            return new Pair(0, false);
        }
        return new Pair(Math.max(left.h, right.h)+1, true);
    }
}