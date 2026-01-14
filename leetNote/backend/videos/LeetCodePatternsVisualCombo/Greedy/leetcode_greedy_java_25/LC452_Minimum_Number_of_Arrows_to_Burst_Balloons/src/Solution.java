import java.util.*;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Long.compare((long)a[1], (long)b[1]));
        int arrows = 0;
        long end = Long.MIN_VALUE;
        for (int[] p : points) {
            if (arrows == 0 || p[0] > end) {
                arrows++;
                end = p[1];
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][] pts = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(new Solution().findMinArrowShots(pts)); // 2
    }
}
