class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;
        ans += numOnes >= k ? k : numOnes;
        k -= numOnes;
        if(k <= 0) return ans;
        ans += 0;
        k -= numZeros;
        if(k <= 0) return ans;
        ans += numNegOnes >= k ? k*-1 : numNegOnes*-1;
        return ans;
    }
}