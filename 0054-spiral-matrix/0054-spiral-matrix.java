class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        ArrayList<Integer> al = new ArrayList<>();
        while(true){
            for(int j = left; j <= right; j++){
                al.add(matrix[top][j]);
            }
            if(top > bottom || left > right) break;
            top++;
            for(int i = top; i <= bottom; i++){
                al.add(matrix[i][right]);
            }
            if(top > bottom || left > right) break;
            right--;
            for(int j = right; j >= left; j--){
                al.add(matrix[bottom][j]);
            }
            if(top > bottom || left > right) break;
            bottom--;
            for(int i = bottom; i>= top; i--){
                al.add(matrix[i][left]);
            }
            if(top > bottom || left > right) break;
            left++;
        }
        return al;
    }
}