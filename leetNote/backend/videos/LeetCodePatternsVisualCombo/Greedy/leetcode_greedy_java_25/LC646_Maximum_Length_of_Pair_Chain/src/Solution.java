import java.util.*;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int[] p : pairs) {
            if (p[0] > end) {
                count++;
                end = p[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        System.out.println(new Solution().findLongestChain(pairs)); // 2
    }
}
