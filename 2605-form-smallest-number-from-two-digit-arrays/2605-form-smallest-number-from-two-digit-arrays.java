class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int m1 = 9;
        int m2 = 9;
        int smallCommon = Integer.MAX_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        for(int v1 : nums1){
            m1 = Math.min(v1, m1);
            hs.add(v1);
        }
        for(int v2 : nums2){
            m2 = Math.min(v2, m2);
            if(hs.contains(v2) == true){
                smallCommon = Math.min(smallCommon, v2);
            }
        }
        // System.out.println(smallCommon);
        int small = 0;
        if(m2 > m1){
            small = m1 * 10 + m2;
        }
        else{
            small = m2 * 10 + m1;
        }
        
        if(small > smallCommon) return smallCommon;
        return small;
    }
}