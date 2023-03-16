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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }
    
    public TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder){
        
        // Base Case
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        
        //Make my node
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = 0;
        
        // Find in Inorder Array
        while(postorder[postEnd] != inorder[idx]){
            idx++;
        }
        
        // Mark leftChildren Count
        int lchildren = idx - inStart;
        
        // Call left child to make it
        root.left = helper(postStart, postStart + lchildren - 1, inStart, idx-1, inorder, postorder);
        
        // Call right child to make it
        root.right = helper(postStart + lchildren, postEnd - 1, idx+1, inEnd, inorder, postorder);
        
        // Return itself
        return root;
    }
}