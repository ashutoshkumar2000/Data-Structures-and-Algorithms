class Solution {
    public int maxSatisfaction(int[] s) {
        int n = s.length;
        Arrays.sort(s);
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(s, 0, 0, dp);
    }
    
    public int solve(int []s, int idx, int time, int[][] dp){
        if(idx == s.length){
            return 0;
        }
        if(dp[idx][time] != -1) return dp[idx][time];
        int exclude = solve(s, idx+1, time, dp);
        int include = (s[idx] * (time+1)) + solve(s, idx+1, time+1, dp);
        int ans = Math.max(exclude, include);
        // System.out.println(ans);
        return dp[idx][time] = ans;
    }
}