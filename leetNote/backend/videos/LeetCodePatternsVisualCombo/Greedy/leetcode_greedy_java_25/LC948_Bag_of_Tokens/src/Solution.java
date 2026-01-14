import java.util.*;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int score = 0, best = 0;
        while (i <= j) {
            if (i <= j && power >= tokens[i]) {
                power -= tokens[i++];
                score++;
                best = Math.max(best, score);
            } else if (score > 0) {
                power += tokens[j--];
                score--;
            } else {
                break;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bagOfTokensScore(new int[]{100,200,300,400}, 200)); // 2
    }
}
