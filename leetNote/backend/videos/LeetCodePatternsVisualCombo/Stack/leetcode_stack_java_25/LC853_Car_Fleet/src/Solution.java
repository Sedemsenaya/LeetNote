import java.util.*;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) { cars[i][0] = position[i]; cars[i][1] = speed[i]; }
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0])); // position desc

        ArrayDeque<Double> st = new ArrayDeque<>();
        for (int[] c : cars) {
            double time = (double)(target - c[0]) / c[1];
            if (st.isEmpty() || time > st.peek()) st.push(time);
            // else merges into fleet ahead
        }
        return st.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3})); // 3
    }
}
