class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m > n) return -1;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n){
            int x = i;
            while(x < n && j < m && haystack.charAt(x) == needle.charAt(j)){
                if(j == 0) k = i;
                if(j == m-1) return i;
                j++;
                x++;
            }
            j = 0;
            i++;
        }
        return -1;
    }
}