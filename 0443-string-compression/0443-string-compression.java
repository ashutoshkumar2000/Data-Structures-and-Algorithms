class Solution {
    public int compress(char[] chars) {
        int i  = 0; int j = 0;
        int n = chars.length;
        while(i < n){
            int count = 1;
            while( i < n-1 && chars[i] == chars[i+1]){
                count++;
                i++;
            }
            chars[j++] = chars[i++];
            if(count > 1){
                String s = count + "";
                for(int k = 0; k < s.length(); k++){
                    chars[j++] = s.charAt(k);
                }
            }
        }
        return j;
    }
}