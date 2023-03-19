class WordDictionary {

    /** Initialize your data structure here. */
    public class Node{
        Node children[];
        boolean isEnd;
        Node(){
            children = new Node[26];
        }
        public boolean find(String word, int i){
            if(i == word.length()){
                return isEnd;
            }
            if(word.charAt(i) == '.'){
                for(Node child : children){
                    if(child != null && child.find(word, i+1)){
                        return true;
                    }
                }
                return false;
            }
            else{
                if(children[word.charAt(i)-'a'] == null){
                    return false;
                }
                else{
                    return children[word.charAt(i)-'a'].find(word, i+1);
                }
            }

        }
        
    }
    private final Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new Node();
            }
            curr = curr.children[c-'a'];
                
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return root.find(word, 0);
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */