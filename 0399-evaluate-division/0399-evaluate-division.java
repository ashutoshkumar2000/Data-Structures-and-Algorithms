class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = makeGraph(eq, values);
        // System.out.println(adj);
        // return new double[3];
        int size = queries.size();
        double[] ans = new double[size];
        for(int i = 0; i < size; i++){
            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            ans[i] = DFS(adj, start, target, visited);
        }
        return ans;
    
    }
    
    public Map<String, Map<String, Double>> makeGraph(List<List<String>> eq, double[] values){
        Map<String, Map<String, Double>> adj = new HashMap<>();
        for(int i = 0; i < values.length; i++){
            String u = eq.get(i).get(0);
            String v = eq.get(i).get(1);
            adj.putIfAbsent(u, new HashMap<>());
            adj.get(u).put(v, values[i]);
            adj.putIfAbsent(v, new HashMap<>());
            adj.get(v).put(u, 1/values[i]);
        }
        return adj;        
    } 
    
    public double DFS(Map<String, Map<String, Double>> map, String curr, String target, Set<String> visited){
        if(!map.containsKey(curr)){
            return -1.0;
        }
        if(map.get(curr).containsKey(target)){
            return map.get(curr).get(target);
        }
        visited.add(curr);
        for(Map.Entry<String, Double> edge : map.get(curr).entrySet()){
            if(!visited.contains(edge.getKey())){
                double weight = DFS(map, edge.getKey(), target, visited);
                if(weight != -1.0)
                    return weight * edge.getValue();
            }
        }
        
        return -1;
    }
}