// LeetCode 139: Word Break (bottom-up DP)
import java.util.*;

public class Main {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode",
                Arrays.asList("leet", "code"))); // true
        System.out.println(wordBreak("catsandog",
                Arrays.asList("cats","dog","sand","and","cat"))); // false
    }
}
