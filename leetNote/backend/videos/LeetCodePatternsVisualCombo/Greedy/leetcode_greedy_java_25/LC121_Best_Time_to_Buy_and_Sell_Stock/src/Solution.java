public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, best = 0;
        for (int p : prices) {
            if (p < min) min = p;
            else best = Math.max(best, p - min);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4})); // 5
    }
}
