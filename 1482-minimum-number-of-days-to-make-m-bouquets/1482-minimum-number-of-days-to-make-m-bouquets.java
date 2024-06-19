class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE, high = 0;
        for(int val: bloomDay) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }
        
        int ans = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int total = 0;
        int n = bloomDay.length;
        for(int i = 0; i < n; i++) {
            if(bloomDay[i] > day) {
                total += count/k;
                count = 0;
            }
            else count++;
        }
        total += count/k;
        if(total >= m) return true;
        return false;
    }
}