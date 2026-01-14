import java.util.*;

public class Solution {
    public String[] expand(String s) {
        List<List<String>> parts = parse(s);
        List<String> res = new ArrayList<>();
        dfs(parts, 0, new StringBuilder(), res);
        Collections.sort(res);
        return res.toArray(new String[0]);
    }

    private void dfs(List<List<String>> parts, int idx, StringBuilder sb, List<String> res) {
        if (idx == parts.size()) {
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        for (String token : parts.get(idx)) {
            sb.append(token);
            dfs(parts, idx + 1, sb, res);
            sb.setLength(len);
        }
    }

    private List<List<String>> parse(String s) {
        List<List<String>> parts = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '{') {
                int j = i + 1;
                List<String> options = new ArrayList<>();
                StringBuilder token = new StringBuilder();
                while (j < s.length() && s.charAt(j) != '}') {
                    char ch = s.charAt(j);
                    if (ch == ',') {
                        options.add(token.toString());
                        token.setLength(0);
                    } else {
                        token.append(ch);
                    }
                    j++;
                }
                options.add(token.toString());
                parts.add(options);
                i = j + 1;
            } else {
                parts.add(Arrays.asList(String.valueOf(s.charAt(i))));
                i++;
            }
        }
        return parts;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().expand("{a,b}c{d,e}f")));
    }
}
