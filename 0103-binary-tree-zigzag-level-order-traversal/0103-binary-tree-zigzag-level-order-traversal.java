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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deq = new ArrayDeque();
        List<List<Integer>> ans = new ArrayList();
        int counter = 0;
        if(root == null) return ans;
        deq.addLast(root);
        while(deq.size() != 0){
            int s = deq.size();
            ArrayList<Integer> list = new ArrayList();
            if(counter % 2 == 0){
                for(int i = 0; i < s; i++){
                    TreeNode node = deq.removeFirst();
                    list.add(node.val);
                    if(node.left != null){
                        deq.addLast(node.left);
                    }
                    if(node.right != null){
                        deq.addLast(node.right);
                    }
                }
            }
            else{
                for(int i = s-1; i >= 0; i--){
                    TreeNode node = deq.removeLast();
                    list.add(node.val);
                    if(node.right != null){
                        deq.addFirst(node.right);
                    }
                    if(node.left != null){
                        deq.addFirst(node.left);
                    }
                    
                }
            }
            counter++;
            ans.add(list);
        }
        return ans;
    }
}