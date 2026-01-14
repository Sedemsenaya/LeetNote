import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nxt = new HashMap<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int x : nums2) {
            while (!st.isEmpty() && x > st.peek()) nxt.put(st.pop(), x);
            st.push(x);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) ans[i] = nxt.getOrDefault(nums1[i], -1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        // [-1,3,-1]
    }
}
