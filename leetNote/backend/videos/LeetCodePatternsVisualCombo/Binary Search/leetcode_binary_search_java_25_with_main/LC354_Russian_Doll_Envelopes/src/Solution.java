import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int[] tails = new int[envelopes.length];
        int size = 0;
        for (int[] e : envelopes) {
            int h = e[1];
            int i = lowerBound(tails, 0, size, h);
            tails[i] = h;
            if (i == size) size++;
        }
        return size;
    }

    private int lowerBound(int[] a, int lo, int hi, int x) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
