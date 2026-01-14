import java.util.*;

public class Solution {
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        int best = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                st.pop();
                if (st.isEmpty()) st.push(i);
                else best = Math.max(best, i - st.peek());
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")()())")); // 4
    }
}
