class Solution {
    int parent[];
    int ht[];
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        
        //init
        
        parent = new int[n];
        ht = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        
        boolean ans [] = new boolean[queries.length];
        int i = 0;
        for(int [] query : queries){
            while(i < edgeList.length && query[2] > edgeList[i][2]){
                union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            
            if(find(query[0]) == find(query[1])){
                ans[query[3]] = true;
            }
        }
        return ans;
    }
    
    public void union(int i, int j){
        int x = find(i);
        int y = find(j);
        if(x == y) return;
        if(ht[x] > ht[y]){
            parent[y] = x;
        }
        else if(ht[y] > ht[x]){
            parent[x] = y;
        }
        else{
            parent[x] = y;
            ht[y]++;
        }
    }
    
    public int find(int x){
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}