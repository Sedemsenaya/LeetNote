import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) return res;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A',0); map.put('C',1); map.put('G',2); map.put('T',3);

        int mask = (1 << 20) - 1;
        int code = 0;
        Set<Integer> seen = new HashSet<>();
        Set<Integer> added = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            code = ((code << 2) | map.get(s.charAt(i))) & mask;
            if (i >= 9) {
                if (!seen.add(code) && added.add(code)) {
                    res.add(s.substring(i - 9, i + 1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        // [AAAAACCCCC, CCCCCAAAAA]
    }
}
