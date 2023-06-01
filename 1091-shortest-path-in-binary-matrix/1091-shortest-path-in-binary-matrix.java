class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0, 1}); // row, col, count        
        int dir[][] = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] rem = q.remove();
                int row = rem[0];
                int col = rem[1];
                int count = rem[2];
                if(row == n-1 && col == n-1) return count;
                for(int k = 0; k < 8; k++){
                    int nx = row + dir[k][0];
                    int ny = col + dir[k][1];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n || grid[nx][ny] == 1) continue;
                    else{
                        grid[nx][ny] = 1;
                        q.add(new int[] {nx, ny, count+1});
                    }
                }
            }
        }
        return -1;
    }
}