import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int best = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int cur = x, len = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                best = Math.max(best, len);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100,4,200,1,3,2})); // 4
    }
}
