class Solution {
    public int mod = 1000000007;
    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();
        int preSum[][] = new int[n+1][m+1];
        int dp[][][] = new int[n+1][m+1][k+1];
        
        for(int row[][] : dp){
            for(int col[] : row){
                Arrays.fill(col, -1);
            }
        }
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                preSum[i][j] = preSum[i+1][j] + preSum[i][j+1] - preSum[i+1][j+1];
                if(pizza[i].charAt(j) == 'A'){
                    preSum[i][j] += 1;
                }
                if(preSum[i][j] > 0) dp[i][j][1] = 1;
            }
        }
        
        return noOfWays(preSum, 0, 0, k, dp);
    }
    
    public int noOfWays(int[][]preSum, int x, int y, int k, int[][][] dp){
        if(k == 0) return 1;
        if(dp[x][y][k] != -1) return dp[x][y][k];
        if(preSum[x][y] == 0) return 0;
        
        int ans = 0;
        for(int i = x+1; i < preSum.length; i++){
            if(preSum[x][y] - preSum[i][y] > 0){
                ans = (ans%mod + noOfWays(preSum, i, y, k-1, dp)%mod)%mod;
            }
        }
        
        for(int j = y+1; j < preSum[0].length; j++){
            if(preSum[x][y] - preSum[x][j] > 0){
                ans = (ans%mod + noOfWays(preSum, x, j, k-1, dp)%mod)%mod;
            }
        }
        
        return dp[x][y][k] = ans;
    }
}