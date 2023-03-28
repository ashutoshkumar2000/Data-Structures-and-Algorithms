class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp [] = new int[n];
        Arrays.fill(dp, -1);
        return solve(days, costs, 0, dp);
    }
    
    public int solve(int[] days, int costs[], int idx, int[] dp){        
        if(idx == days.length) return 0; // Base Case 
        
        if(dp[idx] != -1) return dp[idx]; // Memoization benift
        
        int weekPassEndDate = days[idx] + 6; // Calculation of end date for week long Pass
        int i = idx+1;
        while(i < days.length && weekPassEndDate >= days[i]) i++;
        
        int MonthPassEndDate = days[idx] + 29; // Calculation of end date for month long Pass
        int j = idx+1;
        while(j < days.length && MonthPassEndDate >= days[j]) j++;
        
        
        int dailyPass = solve(days, costs, idx+1, dp) + costs[0]; // Creating a Euler Tree
        int weekPass = solve(days, costs, i, dp) + costs[1];
        int monthPass = solve(days, costs, j, dp) + costs[2];
        
        int ans = Math.min(dailyPass, Math.min(weekPass, monthPass)); // Finding the minimum cost
        
        dp[idx] = ans; // Memoization
        
        return ans; // Return ans
    }
}