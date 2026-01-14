public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int best = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            best = Math.max(best, h * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
    }
}
