class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i = 1; i < n; i++) {
            int prev = nums[i-1];
            int curr = nums[i];
            if(prev >= curr) {
                int newCurr = prev+1;
                int diff = newCurr - curr;
                nums[i] = newCurr;
                ans += diff;
            }
        }
        return ans;
    }
}