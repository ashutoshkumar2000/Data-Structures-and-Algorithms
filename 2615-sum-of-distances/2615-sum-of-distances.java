class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        HashMap<Integer,long[]> hm2=new HashMap<>();
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            int val=nums[i];
            List<Integer> list=hm.getOrDefault(val,new ArrayList<>());
            list.add(i);
            hm.put(val,list);
        }
        
        for(int key:hm.keySet()){
            List<Integer> list=hm.get(key);
            long t=0;
            int fir=list.get(0);
            for(int val:list) t+=(val-fir);
            hm2.put(key,new long[]{t,0});
        }
        
        long[] ans=new long[n];
        
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            List<Integer> list=hm.get(val);
            int size=list.size();
            if(size==1) continue;
            long[] v=hm2.get(val);
            int idx=(int)v[1];
            int diff=idx!=0 ? list.get(idx)-list.get(idx-1) : 0;
            long sub= idx<n-1 ? (size-idx-1)*diff:0;
            long add= idx-1>0 ? (v[1]-1)*diff:0;
            v[1]++;
            ans[i]=v[0]-sub+add;
            v[0]=ans[i];
        }
     return ans;
    }
}