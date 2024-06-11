class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = arr1.length;
        int m = arr2.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            int key = arr1[i];
            if(map.containsKey(key)) {
                int val = map.get(key)+1;
                map.put(key, val);
            }
            else {
                map.put(key, 1);
            }
        }
        int idx = 0;
        for (int i = 0; i < m; i++) {
            int key = arr2[i];
            int val = map.get(key);
            while(val > 0){
                ans[idx++] = key;
                val--;
            }
            map.put(key, val);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            while(val > 0) {
                ans[idx++] = key;
                val--;
            }
        }
        return ans;
    }
}