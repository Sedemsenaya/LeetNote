import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums1) freq.put(x, freq.getOrDefault(x, 0) + 1);

        int[] tmp = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;
        for (int x : nums2) {
            int c = freq.getOrDefault(x, 0);
            if (c > 0) {
                tmp[idx++] = x;
                if (c == 1) freq.remove(x);
                else freq.put(x, c - 1);
            }
        }
        return Arrays.copyOf(tmp, idx);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{1,2,2,1}, new int[]{2,2}))); // [2,2]
    }
}
