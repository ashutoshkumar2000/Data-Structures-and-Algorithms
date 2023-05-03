class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        for(int v : nums1){
            s1.add(v);
        }
        for(int v : nums2){
            if(!s1.contains(v) && !al2.contains(v))al2.add(v);
            s2.add(v);
        }
        for(int v : nums1){
            if(!s2.contains(v) && !al1.contains(v)) al1.add(v);
        }
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(al1); ls.add(al2);
        return ls;
    }
}