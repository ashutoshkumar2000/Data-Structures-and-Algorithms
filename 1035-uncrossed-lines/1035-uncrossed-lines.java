class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n][m];
        for(int []row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, nums1, nums2, dp);
    }
    public int solve(int i1, int i2, int[] n1, int[] n2, int[][] dp){
        if(i1 >= n1.length || i2 >= n2.length){
            return 0;
        }
        if(dp[i1][i2] != -1) return dp[i1][i2];
        
        if(n1[i1] == n2[i2]){
            return dp[i1][i2] = solve(i1+1, i2+1, n1, n2, dp)+1;
        }
        else{
            return dp[i1][i2] = Math.max(solve(i1+1, i2, n1, n2, dp), solve(i1, i2+1, n1, n2, dp));
        }
    }
}