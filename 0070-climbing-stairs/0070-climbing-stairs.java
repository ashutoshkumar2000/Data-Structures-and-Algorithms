class Solution {
    public int climbStairs(int n) {
        return fib(n);
    }
    public static int fib(int num){
        int dp[] = new int[num+1];
        Arrays.fill(dp, -1);
        return solver(num, dp, 1000000007);
    }

    public static int solver(int num, int[] dp, int mod){
        if(num == 0 || num == 1 || num == 2){
            return num;
        }
        if(dp[num] != -1){
            return dp[num];
        }
        int myFib = (solver(num-1, dp, mod) + solver(num-2, dp, mod));
        dp[num] = myFib;
        return myFib;
    }
}