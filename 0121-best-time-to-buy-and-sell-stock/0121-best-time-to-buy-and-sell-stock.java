class Solution {
    public int maxProfit(int[] prices) {
        int T_i10 = 0; //Sell or Rest
        int T_i11 = Integer.MIN_VALUE; //Buy or Rest
        for(int price : prices){
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }
        return T_i10;
    }
}