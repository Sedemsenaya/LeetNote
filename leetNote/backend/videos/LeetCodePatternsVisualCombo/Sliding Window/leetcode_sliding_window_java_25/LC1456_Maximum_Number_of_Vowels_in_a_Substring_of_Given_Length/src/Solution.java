public class Solution {
    public int maxVowels(String s, int k) {
        int cur = 0;
        for (int i = 0; i < k && i < s.length(); i++) if (isVowel(s.charAt(i))) cur++;
        int best = cur;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) cur++;
            if (isVowel(s.charAt(i - k))) cur--;
            best = Math.max(best, cur);
        }
        return best;
    }

    private boolean isVowel(char ch) {
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxVowels("abciiidef", 3)); // 3
    }
}
