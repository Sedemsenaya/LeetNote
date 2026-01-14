public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for (int x : cnt) if (x != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram")); // true
    }
}
