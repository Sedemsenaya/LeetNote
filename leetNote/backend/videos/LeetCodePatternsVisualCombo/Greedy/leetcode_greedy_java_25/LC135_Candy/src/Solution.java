public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] cand = new int[n];
        for (int i = 0; i < n; i++) cand[i] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) cand[i] = cand[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) cand[i] = Math.max(cand[i], cand[i + 1] + 1);
        }
        int sum = 0;
        for (int x : cand) sum += x;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1,0,2})); // 5
    }
}
