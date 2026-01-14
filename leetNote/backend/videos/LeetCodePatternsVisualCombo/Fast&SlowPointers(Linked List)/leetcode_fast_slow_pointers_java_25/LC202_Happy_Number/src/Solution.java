public class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int next(int x) {
        int sum = 0;
        while (x > 0) {
            int d = x % 10;
            sum += d * d;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19)); // true
        System.out.println(new Solution().isHappy(2));  // false
    }
}
