class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        long sum = 0;
        for(int sal : salary){
            max = Math.max(max, sal);
            min = Math.min(min, sal);
            sum += sal;
        }
        sum = sum - (max+min);
        System.out.println(min);
        return (double)sum/(double)(salary.length - 2);
    }
}