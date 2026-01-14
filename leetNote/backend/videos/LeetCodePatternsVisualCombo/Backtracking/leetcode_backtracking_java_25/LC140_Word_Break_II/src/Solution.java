import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, dict, memo);
    }

    private List<String> dfs(String s, int idx, Set<String> dict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(idx)) return memo.get(idx);
        List<String> res = new ArrayList<>();
        if (idx == s.length()) {
            res.add("");
            memo.put(idx, res);
            return res;
        }

        for (int end = idx + 1; end <= s.length(); end++) {
            String word = s.substring(idx, end);
            if (!dict.contains(word)) continue;
            for (String tail : dfs(s, end, dict, memo)) {
                if (tail.isEmpty()) res.add(word);
                else res.add(word + " " + tail);
            }
        }
        memo.put(idx, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
    }
}
