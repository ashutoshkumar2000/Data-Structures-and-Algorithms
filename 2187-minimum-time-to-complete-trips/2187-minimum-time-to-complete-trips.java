class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = Long.MAX_VALUE;
        for(int t : time){
            low = Math.min(low, t);
        }
        long high = totalTrips * low;
        while(low < high){
            long mid = (low + high)/2;
            if(checkIfPossible(mid, totalTrips, time)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean checkIfPossible(long validTimeRange, int totalTrips, int[] time){
        long trips = 0;
        for(int t : time){
            trips += validTimeRange/t;
        }
        if(trips >= totalTrips){
            return true;
        }
        return false;
    }
}