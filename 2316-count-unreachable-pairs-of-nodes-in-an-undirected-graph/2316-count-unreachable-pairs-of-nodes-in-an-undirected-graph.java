class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans=0;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int d[]:edges){
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        boolean vis[]=new boolean[n];
        int nvis=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int cnt=dfs(i,vis,adj);
                ans+=(long)cnt*nvis;
                nvis+=cnt;
            }
        }
        return ans;
    }
    public static int dfs(int i,boolean vis[],List<List<Integer>>adj){
        vis[i]=true;
        int cnt=1;
        for(int z:adj.get(i)){
            if(!vis[z]){
                cnt+=dfs(z,vis,adj);
            }
        }
        return cnt;
    }
}