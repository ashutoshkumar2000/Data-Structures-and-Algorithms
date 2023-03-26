class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Long> ans = new ArrayList<>();
        long[] preSum = new long[n+1];
       for (int i = 1; i <= n; i++)
            preSum[i] = preSum[i - 1] + nums[i - 1];
        
        
        for(int q = 0; q < queries.length; q++){
            int qry = queries[q];
            int lo = 0;
            int hi = n;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] < qry) lo = mid + 1;
                else hi = mid;
            }
            ans.add(1L * qry * (2 * lo - n) + preSum[n] - 2 * preSum[lo]);
        }
        return ans;
    }
}