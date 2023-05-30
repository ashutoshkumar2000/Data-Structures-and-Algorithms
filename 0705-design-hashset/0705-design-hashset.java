class MyHashSet {
    int[] HashSet;

    public MyHashSet() {
        HashSet = new int[1000001];
        Arrays.fill(HashSet, -1);
    }
    
    public void add(int key) {
        HashSet[key] = key;
    }
    
    public void remove(int key) {
        HashSet[key] = -1;
    }
    
    public boolean contains(int key) {
        if(HashSet[key] != -1) return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */