class Solution {
    public int partitionString(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                count++;
                set = new HashSet();
                set.add(c);
            }
            else{
                set.add(c);
            }
        }
        if(!set.isEmpty()) count++;
        return count;
    }
}