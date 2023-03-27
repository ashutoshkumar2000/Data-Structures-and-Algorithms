class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0;
        int j = n;
        int k = 1;
        int len = nums.length;
        int[] nums2 = new int[len];
        while(i < n){
            nums2[k-1] = nums[i];
            nums2[k] = nums[j];
            k+=2;
            i++;
            j++;
        }
        return nums2;
    }
}