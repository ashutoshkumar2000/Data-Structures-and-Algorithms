class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int cost[] = new int[27];
        for(int i = 1; i <= 26; i++){
            cost[i] = i;
        }
        
        for(int i = 0; i < vals.length; i++){
            int c = chars.charAt(i) - 'a' + 1;
            cost[c] = vals[i];
        }
        
        int val[] = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            val[i] = cost[s.charAt(i) - 'a' + 1];
        }
        return kadanes(val);
    }
    public int kadanes(int[] a){
        int size = a.length;
        int max_so_far = 0, max_ending_here = 0;
 
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}