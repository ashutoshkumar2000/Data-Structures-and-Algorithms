class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j))
                        ans += 1;
                }
            }
        }
        return ans;
    }
    
    public boolean dfs(int [][] g, int i, int j){
        // Base Case
        if(i < 0 || j < 0 || i >= g.length || j >= g[0].length) return false;
        
        if(g[i][j] == 1) return true;
        g[i][j] = 1;
        boolean d1 = dfs(g, i, j+1);
        boolean d2 = dfs(g, i+1, j);
        boolean d3 = dfs(g, i, j-1);
        boolean d4 = dfs(g, i-1, j);
        
        return d1 && d2 && d3 && d4;
    }
}