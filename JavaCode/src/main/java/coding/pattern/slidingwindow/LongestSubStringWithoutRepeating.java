package coding.pattern.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeating {

    public static int longestSubString(String str) {
        int i = 0, j = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < str.length()) {
            char c = str.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() == j - i + 1) {
                max = Math.max(max, j - i + 1);
            } else if (map.size() < j - i + 1) {
                while (map.size() < j - i + 1) {
                    char ch = str.charAt(i);
                    int v = map.get(ch) - 1;
                    if (v == 0) {
                        map.remove(ch);
                    } else {
                        map.put(ch, v);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubString("kwwkewf"));
    }
}
