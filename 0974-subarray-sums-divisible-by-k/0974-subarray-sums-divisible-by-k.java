class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int prefix = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            prefix += nums[i];
            prefix = ((prefix%k)+k)%k;
            if(map.containsKey(prefix)){
                ArrayList<Integer> val = map.get(prefix);
                val.add(i);
                map.put(prefix, val);
            }
            else {
                ArrayList<Integer> val = new ArrayList<>();
                val.add(i);
                map.put(prefix, val);
            }
        }
        int ans = 0;        
        for(Map.Entry<Integer, ArrayList<Integer>> elem: map.entrySet()) {
            int key = elem.getKey();
            ArrayList<Integer> val = elem.getValue();
            if(key == 0) {
               ans += (val.size() * (val.size()+1))/2;
            }
            else if(val.size() > 1) {
                ans += ((val.size()-1) * val.size())/2;
            }
        }
        return ans;
    }
}