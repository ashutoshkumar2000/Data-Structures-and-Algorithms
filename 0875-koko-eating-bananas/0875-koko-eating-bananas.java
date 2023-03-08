class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int pile : piles){
            high = Math.max(high, pile);
        }
        while(low < high){
            int mid = low + (high-low)/2;
            if(isPossible(mid, piles, h)){
                high = mid;
            }
            else{
                low = mid+1;
            }
            
        }
        return high;
    }
    public boolean isPossible(int speed, int [] piles, int h){
        int hrs = 0;
        for(int pile : piles){
            hrs += pile/speed;
            if(pile%speed != 0){
                hrs++;
            }
        }
        return hrs <= h;
    }
}