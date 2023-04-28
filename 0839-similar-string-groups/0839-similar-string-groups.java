class Solution {
    int parent[];
    int ht[];
    int ans = 0;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        ans = n;
        int N = n;
        // while(N-- > 0){
        //     parent[N] = N;
        // }
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        ht = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(areSimilar(strs[i], strs[j])){
                    // System.out.println(strs[i] + ", " + strs[j]);
                    union(i, j);
                }
            }
        }
        return calc();
    }
    
    public void union(int i, int j){
        int x = find(i);
        int y = find(j);
        if(x == y) return;
        if(ht[y] > ht[x]){
            parent[x] = y;
        }
        else if(ht[y] < ht[x]){
            parent[y] = x;
        }
        else{
            parent[x] = y;
            ht[y]++;
        }
        ans--;
    }
    
    public int find(int x){
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
            x = parent[x];
        }
        
        return x;
    }
    
    public int calc(){
        int cnt = 0;
        for(int i = 0; i < parent.length; i++){
            System.out.print(parent[i] + ", ");
            if(i == parent[i]) cnt++;
        }
        return cnt;
    }
    
    public boolean areSimilar(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
            if(count > 2) return false;
        }
        return true;
    }
}