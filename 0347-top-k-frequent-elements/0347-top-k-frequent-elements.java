class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int ans[] = new int[k];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val[] = new int[] {entry.getKey(), entry.getValue()};
            pq.add(val);
        }
        int i = 0;
        while(!pq.isEmpty() && k-->0){
            ans[i] = pq.remove()[0];
            i++;
        }
        return ans;
    }
}