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
    public class DiaPair{
      int ht;
      int dia;
      DiaPair(){
          ht = 0;
          dia = 0;
      }
  }    
    
    public int diameterOfBinaryTree(TreeNode A) {
       if(A == null){
            return 0;
        }
        int left = height(A.left);
        int right = height(A.right);
        return Math.max(diameterOfBinaryTree(A.left), Math.max(diameterOfBinaryTree(A.right), left + right));
    }
    
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right)+1;
    }
}