import java.util.*;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        ArrayDeque<Integer> st = new ArrayDeque<>(); // decreasing
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            while (!st.isEmpty() && nums[i] > st.peek()) {
                s3 = Math.max(s3, st.pop());
            }
            st.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{3,1,4,2})); // true
    }
}
