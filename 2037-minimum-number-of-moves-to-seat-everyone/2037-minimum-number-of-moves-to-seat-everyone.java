class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int diff = Math.abs(seats[i] - students[i]);
            ans += diff;
        }
        return ans;
    }
}