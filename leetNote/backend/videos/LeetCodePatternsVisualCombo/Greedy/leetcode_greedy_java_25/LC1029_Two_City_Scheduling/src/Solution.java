import java.util.*;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b) -> Integer.compare((a[0]-a[1]), (b[0]-b[1])));
        int n = costs.length / 2;
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += (i < n) ? costs[i][0] : costs[i][1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] c = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(new Solution().twoCitySchedCost(c)); // 110
    }
}
