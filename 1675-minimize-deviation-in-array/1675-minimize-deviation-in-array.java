class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int minV = Integer.MAX_VALUE;
        for(int i : nums){
            if(i%2!=0){
                i = i*2;
            }
            pq.offer(i);
            minV = Math.min(i, minV);
        }
        int minD = Integer.MAX_VALUE;
        while(true){
            int maxV = pq.poll();
            minD = Math.min(minD, maxV-minV);
            if(maxV%2==1){
                break;
            }
            maxV=maxV/2;
            minV = Math.min(maxV, minV);
            pq.offer(maxV);
        }
        return minD;
    }
}