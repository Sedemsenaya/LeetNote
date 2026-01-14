import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] cnt = new int[26];
            for (char ch : s.toCharArray()) cnt[ch - 'a']++;
            String key = Arrays.toString(cnt);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] in = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Solution().groupAnagrams(in));
    }
}
