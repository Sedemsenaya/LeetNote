import java.util.*;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) res.add(new int[]{lo, hi});
            if (firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a = {{0,2},{5,10},{13,23},{24,25}};
        int[][] b = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(new Solution().intervalIntersection(a, b)));
        // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    }
}
