public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] t : trips) max = Math.max(max, t[2]);
        int[] diff = new int[max + 2];
        for (int[] t : trips) {
            int num = t[0], from = t[1], to = t[2];
            diff[from] += num;
            diff[to] -= num;
        }
        int cur = 0;
        for (int i = 0; i <= max; i++) {
            cur += diff[i];
            if (cur > capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        System.out.println(new Solution().carPooling(trips, 4)); // false
    }
}
