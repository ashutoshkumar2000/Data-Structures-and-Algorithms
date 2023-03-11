class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        subset(0, nums.length, new ArrayList<>(), nums);
        return res;
    }
    public void subset(int i, int n, ArrayList<Integer> curr, int[] nums){
        if(i == n){
            return;
        }
        curr.add(nums[i]);
        res.add(new ArrayList<>(curr));
        subset(i+1, n, curr, nums);
        curr.remove(curr.size()-1);
        subset(i+1, n, curr, nums);
    }
}