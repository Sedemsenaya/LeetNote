import java.util.*;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1])); // units desc
        int units = 0;
        for (int[] b : boxTypes) {
            if (truckSize == 0) break;
            int take = Math.min(truckSize, b[0]);
            units += take * b[1];
            truckSize -= take;
        }
        return units;
    }

    public static void main(String[] args) {
        int[][] bt = {{1,3},{2,2},{3,1}};
        System.out.println(new Solution().maximumUnits(bt, 4)); // 8
    }
}
