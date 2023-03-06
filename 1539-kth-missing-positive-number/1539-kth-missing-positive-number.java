class Solution {
    public int findKthPositive(int[] arr, int k) {
        int max = arr[arr.length-1];
        ArrayList<Integer> al = new ArrayList<>();
        int j = 0;
        for(int i = 0; i <= max; i++){
            if(i == arr[j]){
                j++;
            }
            else{
                al.add(i);
            }
        }
        System.out.println(al);
        if(k < al.size()){
            return al.get(k);
        }
        else{
            return max - (al.size() - k-1);
        }
    }
}