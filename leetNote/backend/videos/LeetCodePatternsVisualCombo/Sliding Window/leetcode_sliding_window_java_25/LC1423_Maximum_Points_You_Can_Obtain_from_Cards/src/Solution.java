public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for (int x : cardPoints) total += x;
        if (k == n) return total;

        int window = n - k;
        int sum = 0;
        for (int i = 0; i < window; i++) sum += cardPoints[i];
        int minWindow = sum;
        for (int i = window; i < n; i++) {
            sum += cardPoints[i] - cardPoints[i - window];
            minWindow = Math.min(minWindow, sum);
        }
        return total - minWindow;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(new int[]{1,2,3,4,5,6,1}, 3)); // 12
    }
}
