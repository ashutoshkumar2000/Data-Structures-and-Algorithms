class Solution {
    public int[][] generateMatrix(int n) {
        int [][] mat = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int v = 1;
        while(true){
            //left to right
            for(int j = left; j <= right; j++){
                mat[top][j] = v;
                v++;
            }
            top++;
            if(top > bottom || left > right) break;
            
            //top to bottom
            for(int i = top; i <= bottom; i++){
                mat[i][right] = v;
                v++;
            }
            right--;
            if(top > bottom || left > right) break;
            
            //right to left
            for(int j = right; j >= left; j--){
                mat[bottom][j] = v;
                v++;
            }
            bottom--;
            if(top > bottom || left > right) break;
            //bottom to top
            for(int i = bottom; i >= top; i--){
                mat[i][left] = v;
                v++;
            }
            left++;
            if(top > bottom || left > right) break;
        }
        return mat;
    }
}