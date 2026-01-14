import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}")); // true
        System.out.println(new Solution().isValid("(]")); // false
    }
}
