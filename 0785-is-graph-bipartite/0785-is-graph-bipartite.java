class Solution {
    class Pair{
        int vtx;
        int color;
        Pair(int vtx, int color){
            this.vtx = vtx;
            this.color = color;
        }
    }
    ArrayList<Integer> adj[];
    public boolean isBipartite(int[][] B) {
        int A = B.length;
        adj = new ArrayList[A];
        for(int i = 0; i < A; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < B.length; i++){
            int u = i;
            for(int j = 0; j < B[i].length; j++){
                int v = B[i][j];
                adj[u].add(v);
                adj[v].add(u);
            }
            
        }
         Queue<Pair> que = new LinkedList();
        int vis[] = new int[A];
        Arrays.fill(vis, -1);
        for(int i = 0; i < A; i++){
            if(vis[i] == -1){
                que.add(new Pair(i, 1));
                vis[i] = 1;
                if(!bfs(que, vis)){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    public boolean bfs(Queue<Pair> que, int[] vis){
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                Pair p = que.remove();
                int color = p.color;
                int vtx = p.vtx;
                for(int nbr : adj[vtx]){
                    if(vis[nbr] == color){
                        return false;
                    }
                    
                    if(vis[nbr] == -1){
                        vis[nbr] = color == 1 ? 2 : 1;
                        que.add(new Pair(nbr, vis[nbr]));
                    }
                }
            }
        }
        return true;
    }
}