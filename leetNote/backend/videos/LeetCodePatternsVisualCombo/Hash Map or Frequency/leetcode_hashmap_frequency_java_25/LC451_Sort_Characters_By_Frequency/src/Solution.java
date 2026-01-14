import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) sb.append(e.getKey());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree")); // eetr (or eert)
    }
}
