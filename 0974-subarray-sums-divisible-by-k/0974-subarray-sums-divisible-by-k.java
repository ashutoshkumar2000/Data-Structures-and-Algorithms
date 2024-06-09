class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            prefix += nums[i];
            prefix = ((prefix%k)+k)%k;
            if(map.containsKey(prefix)){
                int val = map.get(prefix);
                val++;
                map.put(prefix, val);
            }
            else {
                int val = 1;
                map.put(prefix, val);
            }
        }
        int ans = 0;        
        for(Map.Entry<Integer, Integer> elem: map.entrySet()) {
            int key = elem.getKey();
            int val = elem.getValue();
            if(key == 0) {
               ans += (val * (val+1))/2;
            }
            else if(val > 1) {
                ans += ((val-1) * val)/2;
            }
        }
        return ans;
    }
}