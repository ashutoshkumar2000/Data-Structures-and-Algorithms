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
    
    public int diameterOfBinaryTree(TreeNode root) {
        DiaPair ans = helper(root);
        return ans.dia;
    }
    
    public DiaPair helper(TreeNode root){
      if(root == null){
          return new DiaPair();
      }
      DiaPair left = helper(root.left);
      DiaPair right = helper(root.right);
      DiaPair myPair = new DiaPair();
      myPair.ht = Math.max(left.ht, right.ht) + 1;
      myPair.dia = Math.max(left.ht + right.ht, Math.max(left.dia, right.dia));
      return myPair;
  }
}