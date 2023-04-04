class Solution {
    public int partitionString(String s) {
        int count = 0;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(freq[c] == 1){
                count++;
                freq = new int[26];
                freq[c] = 1;
            }
            else{
                freq[c] = 1;
            }
        }
        for(int i = 0; i < 26; i++){
            if(freq[i] == 1){
                count++;
                break;
            }
        }
        return count;
    }
}