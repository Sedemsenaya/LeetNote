import java.util.*;

public class Solution {
    private static final String[] MAP = {
            "",    "",    "abc",  "def",  "ghi",
            "jkl", "mno", "pqrs", "tuv",  "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String digits, int idx, StringBuilder sb, List<String> res) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = MAP[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
