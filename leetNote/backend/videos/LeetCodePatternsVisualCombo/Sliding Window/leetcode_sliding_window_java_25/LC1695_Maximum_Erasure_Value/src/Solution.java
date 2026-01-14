import java.util.*;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> last = new HashMap<>();
        int best = 0;
        int sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            int v = nums[r];
            sum += v;
            if (last.containsKey(v) && last.get(v) >= l) {
                int nl = last.get(v) + 1;
                while (l < nl) sum -= nums[l++];
            }
            last.put(v, r);
            best = Math.max(best, sum);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUniqueSubarray(new int[]{4,2,4,5,6})); // 17
    }
}
