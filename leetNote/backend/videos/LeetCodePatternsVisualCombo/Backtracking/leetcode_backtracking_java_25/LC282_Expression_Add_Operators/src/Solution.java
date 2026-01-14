import java.util.*;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num, 0, target, 0L, 0L, new StringBuilder(), res);
        return res;
    }

    // value = current evaluated value
    // last = last multiplicative component (for handling '*')
    private void dfs(String s, int idx, int target, long value, long last, StringBuilder sb, List<String> res) {
        if (idx == s.length()) {
            if (value == target) res.add(sb.toString());
            return;
        }
        int len0 = sb.length();
        for (int end = idx; end < s.length(); end++) {
            if (s.charAt(idx) == '0' && end > idx) break; // leading zero
            long cur = Long.parseLong(s.substring(idx, end + 1));

            if (idx == 0) {
                sb.append(cur);
                dfs(s, end + 1, target, cur, cur, sb, res);
                sb.setLength(len0);
            } else {
                // +
                sb.append('+').append(cur);
                dfs(s, end + 1, target, value + cur, cur, sb, res);
                sb.setLength(len0);

                // -
                sb.append('-').append(cur);
                dfs(s, end + 1, target, value - cur, -cur, sb, res);
                sb.setLength(len0);

                // *
                sb.append('*').append(cur);
                dfs(s, end + 1, target, value - last + last * cur, last * cur, sb, res);
                sb.setLength(len0);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("123", 6)); // ["1+2+3","1*2*3"]
    }
}
