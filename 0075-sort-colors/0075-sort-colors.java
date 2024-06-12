class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int red = 0; //0
        int white = 0; //1
        int blue = 0; //2
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(num == 0) {
                red++;
            }
            else if(num == 1) {
                white++;
            }
            else {
                blue++;
            }
        }
        int i = 0;
        while(red-- > 0) {
            nums[i++] = 0;
        }
        while(white-- > 0) {
            nums[i++] = 1;
        }
        while(blue-- > 0) {
            nums[i++] = 2;
        }
    }
}