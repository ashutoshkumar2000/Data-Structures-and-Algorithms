class Solution {
    public int minInsertions(String s) {
        if(s.length() == 1) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return s.length() - maxPalSub(s.toCharArray(), 0, s.length()-1, dp);
    }
    
    public int maxPalSub(char[] s, int i, int j, int[][] dp){
        if(i == j){
            return dp[i][j] = 1;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s[i] == s[j] && i+1 == j){
            return dp[i][j] = 2;
        }
        
        if(s[i] == s[j]){
            return dp[i][j] = maxPalSub(s, i+1, j-1, dp) + 2;
        }
        
        // s[i] != s[j]
        return dp[i][j] = Math.max(maxPalSub(s, i+1, j, dp), maxPalSub(s, i, j-1, dp));
    }
}