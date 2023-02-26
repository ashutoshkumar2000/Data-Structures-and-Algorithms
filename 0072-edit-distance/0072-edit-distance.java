class Solution {
    public int minDistance(String X, String Y) {
        int m = X.length();
		int n = Y.length();
		int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];
        for(int j = 0; j <= n; j++){
            prev[j] = j;
        }
		for (int i = 0; i <= m; i++) {
            // int[] cur = new int[n + 1];
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					cur[j] = j;
				} else if (j == 0) {
					cur[j] = i;
				} else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					cur[j] = prev[j - 1];
				} else {
					cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
				}
			}
            prev = (int[])(cur.clone());;
		}
		return prev[n];
        
    }
}