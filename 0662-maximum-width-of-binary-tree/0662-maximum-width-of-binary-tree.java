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
    public int widthOfBinaryTree(TreeNode root) {
        TreeNode nullTreeNode = new TreeNode(-1);
        if(root == null){
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        que.add(new Pair(root, 0));
        while(!que.isEmpty()){
            int size = que.size();
            int leftIdxOfStart = que.peek().getValue();
            int index = 0; // Right idx
            while(size-- > 0){
                Pair<TreeNode, Integer> pair = que.poll();
                TreeNode node = pair.getKey();
                index = pair.getValue();
                if(node.left != null){
                    que.add(new Pair(node.left, index * 2));
                }
                if(node.right != null){
                    que.add(new Pair(node.right,(index*2)+1));
                }
            }
            max = Math.max(max, index - leftIdxOfStart + 1);
        }
        return max;        
    }
}