class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[]dp = new long[n];
        Arrays.fill(dp, -1l);
        return f(questions, 0, dp);
    }
    public long f(int[][] pb, int curr, long[] dp){
        if(curr >= pb.length) return 0;
        // I don't want curr to be considered
        if(dp[curr] != -1l) return dp[curr];
        long ans = f(pb, curr+1, dp);
        
        //consider current
        ans = Math.max(f(pb, curr + pb[curr][1] + 1, dp) + pb[curr][0], ans);
        
        return dp[curr] = ans;
    }
}