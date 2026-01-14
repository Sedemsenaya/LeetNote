import java.util.*;

public class Solution {
    static class Pair {
        char ch; int cnt;
        Pair(char c, int k) { ch = c; cnt = k; }
    }

    public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == ch) {
                st.peek().cnt++;
                if (st.peek().cnt == k) st.pop();
            } else {
                st.push(new Pair(ch, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Pair> it = st.descendingIterator();
        while (it.hasNext()) {
            Pair p = it.next();
            for (int i = 0; i < p.cnt; i++) sb.append(p.ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("deeedbbcccbdaa", 3)); // aa
    }
}
