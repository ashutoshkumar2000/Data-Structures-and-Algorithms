class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        int ans = 0;
        for(int i : weights){
            l = Math.max(l, i);
            r += i;
        }
        while(l <= r){
            int mid = (l+r)/2;
            if(possible(weights, mid, days)){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int[] weights, int capacity, int days){
        int requiredDays = 1;
        int currWt = 0;
        for(int i : weights){
            if(currWt + i > capacity){
                currWt = 0;
                requiredDays++;
            }
            currWt+=i;
        }
        if(requiredDays > days) return false;
        return true;
    }
}