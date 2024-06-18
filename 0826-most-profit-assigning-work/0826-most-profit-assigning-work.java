class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int m = worker.length;
        int ans = 0;
        int arr[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            int d = difficulty[i];
            int p = profit[i];
            arr[i][0] = d;
            arr[i][1] = p;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int j = 0, best = 0;
        for(int i = 0; i < m; i++) {
            int currWorker = worker[i];
            while (j < n) {
                if(currWorker < arr[j][0]) break;
                best = Math.max(arr[j][1], best);
                j++;
            }
            ans += best;
        }
        return ans;
    }
}