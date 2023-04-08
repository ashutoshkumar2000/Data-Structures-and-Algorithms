/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> clonedMap = new HashMap<>();
    public Node cloneGraph(Node node) {
       if (node == null) {
            return null;
        }
   
        if (clonedMap.containsKey(node)) {
            return clonedMap.get(node);
        }
        
        Node cloneNode = new Node(node.val, new ArrayList<>());

        clonedMap.put(node, cloneNode);
 
      for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }
}