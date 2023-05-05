class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int i = 0;
        for(; i < k; i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                max++;
            }
        }
        int ans = max;
        for(; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                max++;
            }
            if(isVowel(s.charAt(i-k))){
                max--;
            }
            ans = Math.max(max, ans);
        }
        return ans;
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}