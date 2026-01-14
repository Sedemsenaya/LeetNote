import java.util.*;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] h = new int[n];
        int best = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) h[c] = (matrix[r][c] == '1') ? h[c] + 1 : 0;
            best = Math.max(best, largestRect(h));
        }
        return best;
    }

    private int largestRect(int[] heights) {
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
        char[][] m = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println(new Solution().maximalRectangle(m)); // 6
    }
}
