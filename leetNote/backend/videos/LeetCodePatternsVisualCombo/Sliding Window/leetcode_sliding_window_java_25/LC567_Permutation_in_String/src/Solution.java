public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] need = new int[26];
        for (char ch : s1.toCharArray()) need[ch - 'a']++;
        int[] win = new int[26];
        int missing = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            int r = s2.charAt(i) - 'a';
            win[r]++;
            if (win[r] <= need[r]) missing--;

            if (i >= s1.length()) {
                int l = s2.charAt(i - s1.length()) - 'a';
                if (win[l] <= need[l]) missing++;
                win[l]--;
            }
            if (missing == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab", "eidbaooo")); // true
        System.out.println(new Solution().checkInclusion("ab", "eidboaoo")); // false
    }
}
