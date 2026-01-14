import java.util.*;

public class Solution {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == ch) st.pop();
            else st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = st.descendingIterator();
        while (it.hasNext()) sb.append(it.next());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca")); // ca
    }
}
