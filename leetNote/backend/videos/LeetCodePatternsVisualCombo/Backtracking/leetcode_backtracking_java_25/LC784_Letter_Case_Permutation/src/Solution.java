import java.util.*;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] a = s.toCharArray();
        dfs(a, 0, res);
        return res;
    }

    private void dfs(char[] a, int i, List<String> res) {
        if (i == a.length) {
            res.add(new String(a));
            return;
        }
        if (Character.isLetter(a[i])) {
            char orig = a[i];
            a[i] = Character.toLowerCase(orig);
            dfs(a, i + 1, res);
            a[i] = Character.toUpperCase(orig);
            dfs(a, i + 1, res);
            a[i] = orig;
        } else {
            dfs(a, i + 1, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
    }
}
