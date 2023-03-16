class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solver(n, dp);
    }
    public int solver(int A, int[] dp){
        if(A == 0){
            return 0;
        }
        if(dp[A] != -1){
            return dp[A];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.floor(Math.sqrt(A)); i++){
            min = Math.min(min, solver(A - i*i, dp));
        }
        min++;
        dp[A] = min;
        return min;
    }
}