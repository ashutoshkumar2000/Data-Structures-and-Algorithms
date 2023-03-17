class Trie {
    class TrieNode{
        boolean isEnd;
        HashMap<Character, TrieNode> child;
        TrieNode(){
            this.child = new HashMap();
            this.isEnd = false;
        }
    }
    public final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode curr = root;
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            if(!curr.child.containsKey(c)){
                curr.child.put(c, new TrieNode());
            }
            curr = curr.child.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        int n = word.length();
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            if(!curr.child.containsKey(c)){
                return false;
            }
            curr = curr.child.get(c);
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int n = prefix.length();
        for(int i = 0; i < n; i++){
            char c = prefix.charAt(i);
            if(!curr.child.containsKey(c)){
                return false;
            }
            curr = curr.child.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */