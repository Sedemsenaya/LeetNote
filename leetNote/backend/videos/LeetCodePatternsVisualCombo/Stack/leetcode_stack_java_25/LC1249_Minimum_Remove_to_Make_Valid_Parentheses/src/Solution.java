import java.util.*;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] remove = new boolean[s.length()];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') st.push(i);
            else if (ch == ')') {
                if (st.isEmpty()) remove[i] = true;
                else st.pop();
            }
        }
        while (!st.isEmpty()) remove[st.pop()] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) if (!remove[i]) sb.append(s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minRemoveToMakeValid("lee(t(c)o)de)")); // lee(t(c)o)de
    }
}
