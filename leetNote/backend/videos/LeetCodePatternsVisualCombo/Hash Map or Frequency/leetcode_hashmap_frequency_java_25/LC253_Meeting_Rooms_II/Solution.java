import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap of end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] meeting : intervals) {
            int start = meeting[0];
            int end = meeting[1];

            // If a room is free, reuse it
            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }
            // Allocate room (new or reused)
            minHeap.offer(end);
        }

        return minHeap.size();
    }


    public static void main(String[] args) {
        Solution sc = new Solution();
        // Test case 1
        int[][] meetings1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Expected: 2, Output: " + sc.minMeetingRooms(meetings1));

        // Test case 2
        int[][] meetings2 = {{7, 10}, {2, 4}};
        System.out.println("Expected: 1, Output: " + sc.minMeetingRooms(meetings2));

        // Test case 3
        int[][] meetings3 = {{1, 5}, {2, 6}, {3, 7}, {4, 8}};
        System.out.println("Expected: 4, Output: " + sc.minMeetingRooms(meetings3));

        // Test case 4 (edge case)
        int[][] meetings4 = {};
        System.out.println("Expected: 0, Output: " + sc.minMeetingRooms(meetings4));
    }
}
