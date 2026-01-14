import java.util.*;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;

        boolean[] used = new boolean[26];
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (used[idx]) continue;
            while (!st.isEmpty() && st.peek() > ch && last[st.peek() - 'a'] > i) {
                used[st.pop() - 'a'] = false;
            }
            st.push(ch);
            used[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = st.descendingIterator();
        while (it.hasNext()) sb.append(it.next());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc")); // acdb
    }
}
