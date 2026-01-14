import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String s, int idx, int parts, StringBuilder sb, List<String> res) {
        if (parts == 4) {
            if (idx == s.length()) res.add(sb.toString());
            return;
        }
        int len0 = sb.length();
        for (int end = idx; end < Math.min(s.length(), idx + 3); end++) {
            if (s.charAt(idx) == '0' && end > idx) break; // leading zero
            int val = Integer.parseInt(s.substring(idx, end + 1));
            if (val > 255) break;

            if (parts > 0) sb.append('.');
            sb.append(val);

            dfs(s, end + 1, parts + 1, sb, res);

            sb.setLength(len0);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }
}
