public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int best = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            best = Math.max(best, h * (j - i));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return best;
    }

    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(h)); // 49
    }
}
