import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        ArrayDeque<String> st = new ArrayDeque<>();
        for (String p : parts) {
            if (p.isEmpty() || p.equals(".")) continue;
            if (p.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = st.descendingIterator();
        while (it.hasNext()) sb.append('/').append(it.next());
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home//foo/")); // /home/foo
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/")); // /c
    }
}
