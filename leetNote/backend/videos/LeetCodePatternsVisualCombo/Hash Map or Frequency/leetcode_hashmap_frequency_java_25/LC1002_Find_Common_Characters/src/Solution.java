import java.util.*;

public class Solution {
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);

        for (String w : words) {
            int[] cnt = new int[26];
            for (char ch : w.toCharArray()) cnt[ch - 'a']++;
            for (int i = 0; i < 26; i++) common[i] = Math.min(common[i], cnt[i]);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int c = 0; c < common[i]; c++) res.add(String.valueOf((char)('a' + i)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[]{"bella","label","roller"})); // [e, l, l]
    }
}
