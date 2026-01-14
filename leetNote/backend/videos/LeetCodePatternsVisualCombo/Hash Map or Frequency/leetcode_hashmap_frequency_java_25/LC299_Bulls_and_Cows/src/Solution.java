public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] freq = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i), b = guess.charAt(i);
            if (a == b) {
                bulls++;
            } else {
                freq[a - '0']++;
                freq[b - '0']--;
            }
        }
        int diffAbsSum = 0;
        for (int x : freq) diffAbsSum += Math.abs(x);
        int cows = (secret.length() - bulls) - diffAbsSum / 2;
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810")); // 1A3B
    }
}
