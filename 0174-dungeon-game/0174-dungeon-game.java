class Solution {
    public int calculateMinimumHP(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int dp[][] = new int[n][m];
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i == n-1 && j == m-1){
                    dp[n-1][m-1] = A[n-1][m-1] < 0 ? Math.abs(A[n-1][m-1])+1 : 1;
                }
                else if(i == n-1){
                    if(A[i][j] >= dp[i][j+1]){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i][j+1] - A[i][j];
                    }
                }
                else if(j == m-1){
                    if(A[i][j] >= dp[i+1][j]){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i+1][j] - A[i][j];
                    }
                }
                else{
                    int minDp = Math.min(dp[i+1][j], dp[i][j+1]);
                    if(A[i][j] > minDp){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = minDp - A[i][j];
                    }
                }
            }
        }
        return dp[0][0];
    }
}