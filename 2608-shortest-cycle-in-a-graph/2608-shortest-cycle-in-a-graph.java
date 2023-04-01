class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            Add_edge(x, y, adj);
        }
        
        return shortestCycle(n, adj);
    }
    public void Add_edge(int x, int y, ArrayList<Integer> gr[])
    {
        gr[x].add(y);
        gr[y].add(x);
    }
    static int shortestCycle(int n, ArrayList<Integer> gr[]){
 
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            int[] par = new int[n];
            Arrays.fill(par, -1);
            dist[i] = 0;
            Queue<Integer> q = new LinkedList<>();
 
            q.add(i);
            while (!q.isEmpty())
            {
                int x = q.poll();

                for (int child : gr[x])
                {
                    if (dist[child] == Integer.MAX_VALUE)
                    {
                        dist[child] = 1 + dist[x];
                        par[child] = x;
                        q.add(child);
                    } else if (par[x] != child && par[child] != x)
                        ans = Math.min(ans, dist[x] + dist[child] + 1);
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }
}