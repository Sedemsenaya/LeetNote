import java.util.*;

public class Solution {
    public int trap(int[] height) {
        int ans = 0;
        ArrayDeque<Integer> st = new ArrayDeque<>(); // indices
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int bottom = st.pop();
                if (st.isEmpty()) break;
                int left = st.peek();
                int width = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[bottom];
                if (h > 0) ans += width * h;
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6
    }
}
