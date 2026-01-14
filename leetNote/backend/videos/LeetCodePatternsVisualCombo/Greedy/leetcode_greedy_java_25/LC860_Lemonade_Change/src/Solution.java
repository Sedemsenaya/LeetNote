public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) five++;
            else if (b == 10) {
                if (five == 0) return false;
                five--; ten++;
            } else { // 20
                if (ten > 0 && five > 0) { ten--; five--; }
                else if (five >= 3) five -= 3;
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[]{5,5,5,10,20})); // true
    }
}
