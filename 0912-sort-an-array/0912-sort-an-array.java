class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < n; i++){
            pq.offer(nums[i]);
        }
        int i = 0;
        while(pq.size() != 0){
            ans[i] = pq.poll();
            i++;
        }
        return ans;
    }
}