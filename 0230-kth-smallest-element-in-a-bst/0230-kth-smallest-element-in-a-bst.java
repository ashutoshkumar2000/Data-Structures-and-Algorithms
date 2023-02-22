/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    int cnt = 0; int ans = 0;
    public int kthSmallest(TreeNode A, int B) {
        solver(A, B);
        return ans;
    }
    public void solver(TreeNode node, int B){
        if(node == null) return;
        solver(node.left, B);
        cnt++;
        if(cnt == B){
            ans = node.val;
            return;
        }
        solver(node.right, B);
    }
}
