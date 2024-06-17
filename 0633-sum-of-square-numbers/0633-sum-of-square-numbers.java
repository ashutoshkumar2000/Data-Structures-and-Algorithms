class Solution {
    public boolean judgeSquareSum(int c) {
        long r = (long) Math.sqrt((double) c);
        long l = 0;
        while(l <= r) {
            long m = (l*l + r*r);
            System.out.println(m);
            if(m == c) return true;
            else if(m < c) l++;
            else r--;
        }
        return false;
    }
}