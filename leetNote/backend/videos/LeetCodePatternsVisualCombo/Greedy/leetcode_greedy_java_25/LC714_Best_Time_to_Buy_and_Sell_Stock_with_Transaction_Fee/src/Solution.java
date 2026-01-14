public class Solution {
    public int maxProfit(int[] prices, int fee) {
        long cash = 0;          // max profit not holding stock
        long hold = -prices[0]; // max profit holding stock
        for (int i = 1; i < prices.length; i++) {
            long newCash = Math.max(cash, hold + prices[i] - fee);
            long newHold = Math.max(hold, cash - prices[i]);
            cash = newCash;
            hold = newHold;
        }
        return (int) cash;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,3,2,8,4,9}, 2)); // 8
    }
}
