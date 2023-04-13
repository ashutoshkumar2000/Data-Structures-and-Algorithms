class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(popped.length != pushed.length) return false;
        int n = pushed.length;
        int j = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[j]){
                j++;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}