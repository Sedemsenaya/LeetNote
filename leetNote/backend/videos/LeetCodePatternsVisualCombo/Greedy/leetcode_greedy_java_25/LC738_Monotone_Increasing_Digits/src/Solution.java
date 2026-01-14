public class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] a = String.valueOf(n).toCharArray();
        int mark = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                a[i - 1]--;
                mark = i;
            }
        }
        for (int i = mark; i < a.length; i++) a[i] = '9';
        return Integer.parseInt(new String(a));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(332)); // 299
    }
}
