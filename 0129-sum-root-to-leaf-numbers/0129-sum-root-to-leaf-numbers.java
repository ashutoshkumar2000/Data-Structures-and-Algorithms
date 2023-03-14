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
    ArrayList<Integer> numbers = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        traverse(root, "");
        for(int v : numbers){
            ans += v;
        }
        return ans;
    }
    
    public void traverse(TreeNode node, String nsf){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            nsf += Integer.toString(node.val);
            numbers.add(Integer.parseInt(nsf));
            nsf = nsf.substring(0, nsf.length()-1);
            return;
        }
        nsf += Integer.toString(node.val);
        traverse(node.left, nsf);
        traverse(node.right, nsf);
        nsf = nsf.substring(0, nsf.length()-1);
        
    }
}