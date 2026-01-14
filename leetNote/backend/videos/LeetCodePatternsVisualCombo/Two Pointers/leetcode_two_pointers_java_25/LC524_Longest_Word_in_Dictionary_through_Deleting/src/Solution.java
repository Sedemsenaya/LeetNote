import java.util.*;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String best = "";
        for (String w : dictionary) {
            if (isSubseq(w, s)) {
                if (w.length() > best.length() || (w.length() == best.length() && w.compareTo(best) < 0)) {
                    best = w;
                }
            }
        }
        return best;
    }

    private boolean isSubseq(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("ale","apple","monkey","plea");
        System.out.println(new Solution().findLongestWord("abpcplea", dict)); // apple
    }
}
