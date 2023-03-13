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
    public boolean flag = false;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // return check(root.left, root.right);     
        return checkIterative(root);
    }
    
    // Recursive
    public boolean check(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        
        return check(left.left, right.right) && check(left.right, right.left);
    }
    
    // Iterarative
    public boolean checkIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(st.size() > 0){
            TreeNode left = st.pop();
            TreeNode right = st.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
        }
        return true;
    }
}