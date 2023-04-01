class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    public int binarySearch(int nums[], int tar, int lo, int hi){
        if(lo > hi){
            return -1;
        }
        int mid = (lo+hi)/2;
        if(nums[mid] == tar){
            return mid;
        }
        else if(nums[mid] > tar){
            return binarySearch(nums, tar, lo, mid-1);
        }
        else{
            return binarySearch(nums, tar, mid+1, hi);
        }
    }
}