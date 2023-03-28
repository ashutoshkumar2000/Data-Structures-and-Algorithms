class Solution {
    public int calculateMinimumHP(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int dp[] = new int[m];

        // Initialize the last cell of the dp array
        dp[m-1] = A[n-1][m-1] < 0 ? Math.abs(A[n-1][m-1])+1 : 1;

        // Calculate the last row of the dp array
        for (int j = m-2; j >= 0; j--) {
            dp[j] = Math.max(dp[j+1] - A[n-1][j], 1);
        }

        // Calculate the rest of the dp array row by row
        for (int i = n-2; i >= 0; i--) {
            dp[m-1] = Math.max(dp[m-1] - A[i][m-1], 1);
            for (int j = m-2; j >= 0; j--) {
                int right = Math.max(dp[j+1] - A[i][j], 1);
                int down = Math.max(dp[j] - A[i][j], 1);
                dp[j] = Math.min(right, down);
            }
        }

        return dp[0];
    }
}