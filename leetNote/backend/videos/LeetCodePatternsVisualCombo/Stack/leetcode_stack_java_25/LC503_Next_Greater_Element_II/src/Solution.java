import java.util.*;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ArrayDeque<Integer> st = new ArrayDeque<>(); // indices
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!st.isEmpty() && nums[idx] > nums[st.peek()]) {
                ans[st.pop()] = nums[idx];
            }
            if (i < n) st.push(idx);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int[]{1,2,1}))); // [2,-1,2]
    }
}
