import java.util.*;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int keep = 0;
        int end = Integer.MIN_VALUE;
        for (int[] in : intervals) {
            if (in[0] >= end) {
                keep++;
                end = in[1];
            }
        }
        return intervals.length - keep;
    }

    public static void main(String[] args) {
        int[][] in = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(new Solution().eraseOverlapIntervals(in)); // 1
    }
}
