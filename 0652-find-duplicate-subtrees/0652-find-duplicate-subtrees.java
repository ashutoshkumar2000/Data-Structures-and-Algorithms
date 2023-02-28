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
    List<TreeNode> ans = new ArrayList();
    HashMap<String, Integer> map = new HashMap();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) return ans;
        helper(root);
        return ans;
    }
    public String helper(TreeNode node){
        if(node == null){
            return "";
        }
        String left = helper(node.left);
        String right = helper(node.right);
        String myKey = node.val + " " + left + " " + right;
        map.put(myKey, map.getOrDefault(myKey, 0)+1);
        if(map.get(myKey)==2){
            ans.add(node);
        }
        return myKey;
    }
}