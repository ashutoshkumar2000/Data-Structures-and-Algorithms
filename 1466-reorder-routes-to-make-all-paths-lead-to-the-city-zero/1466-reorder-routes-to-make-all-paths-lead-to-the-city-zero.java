class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int numReversals = 0;
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(-connection[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (!visited.contains(Math.abs(next))) {
                    if (next > 0) {
                        numReversals++;
                    }
                    visited.add(Math.abs(next));
                    queue.add(Math.abs(next));
                }
            }
        }
        return numReversals;
    }
}
