class Solution {
    public int heightChecker(int[] heights) {
        int expected[] = heights.clone();
        Arrays.sort(expected);
        int n = heights.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(expected[i] != heights[i]) ans++;
        }
        return ans;
    }
}