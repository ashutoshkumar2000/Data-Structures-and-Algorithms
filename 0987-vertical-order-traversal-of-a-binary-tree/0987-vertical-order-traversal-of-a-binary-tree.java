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
    public class Pair{
        int lvl;
        TreeNode node;
        int order;
        Pair(int lvl, int order, TreeNode node){
            this.lvl = lvl;
            this.node = node;
            this.order = order;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> que = new ArrayDeque<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        que.add(new Pair(0, 0,root));
        
        int min = 0, max = 0;
        while(que.size() != 0){
            int size = que.size();
            HashMap<Integer, ArrayList> temp_map = new HashMap<>();
            while(size-- > 0){
                Pair rem = que.remove();
                min = Math.min(min, rem.lvl);
                max = Math.max(max, rem.lvl);
                if(temp_map.containsKey(rem.lvl) == false){
                    temp_map.put(rem.lvl, new ArrayList<>());
                }
                temp_map.get(rem.lvl).add(rem.node.val);
                
                if(rem.node.left != null) que.add(new Pair(rem.lvl-1, rem.order + 1, rem.node.left));
                if(rem.node.right != null) que.add(new Pair(rem.lvl+1, rem.order + 1, rem.node.right));
            }
            for(Integer key : temp_map.keySet()){
                ArrayList<Integer> list = temp_map.get(key);
                Collections.sort(list);
                if(map.containsKey(key) == false){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).addAll(list);
            }
            
        }
        
        for(int i = min; i <= max; i++){
            ArrayList<Integer> al = map.get(i);
            ans.add(al);
        }
        return ans;       
    }
}