class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int v : stones){
            pq.add(v);
        }
        while(pq.size() > 1){
            int max = pq.remove();
            if(pq.size() == 0){
                return max;
            }
            int secMax = pq.remove();
            pq.add(Math.abs(max-secMax));
        }
        
        return pq.remove();
    }
}