import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int best = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!st.isEmpty() && h < heights[st.peek()]) {
                int top = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                best = Math.max(best, heights[top] * width);
            }
            st.push(i);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2,1,5,6,2,3})); // 10
    }
}
