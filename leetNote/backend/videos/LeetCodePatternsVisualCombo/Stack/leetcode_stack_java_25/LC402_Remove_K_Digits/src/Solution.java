import java.util.*;

public class Solution {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while (k > 0 && !st.isEmpty()) { st.pop(); k--; }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = st.descendingIterator();
        while (it.hasNext()) sb.append(it.next());

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++;
        String res = sb.substring(i);
        return res.isEmpty() ? "0" : res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("1432219", 3)); // 1219
        System.out.println(new Solution().removeKdigits("10200", 1));   // 200
    }
}
