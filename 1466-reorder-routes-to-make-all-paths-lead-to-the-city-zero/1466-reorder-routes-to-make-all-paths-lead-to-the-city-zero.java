class Solution {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(-connection[0]);
        }
        int numReversals = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if (!visited[Math.abs(next)]) {
                    if (next > 0) {
                        numReversals++;
                    }
                    visited[Math.abs(next)] = true;
                    queue.add(Math.abs(next));
                }
            }
        }
        return numReversals;
    }
}
