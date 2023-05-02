class Solution {
    public int arraySign(int[] nums) {
        int countNeg = 0;
        for(int num : nums){
            if(num == 0) return 0;
            if(num < 0) countNeg+=1;
        }
        return countNeg%2==0 ? 1:-1;
    }
}