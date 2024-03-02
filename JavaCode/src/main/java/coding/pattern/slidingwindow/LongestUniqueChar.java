package coding.pattern.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueChar {

    public static int longestUniqueCharSize(String str, int k) {
        int i = 0, j = 0, max = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < str.length()) {
            char c = str.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            j++;

            if(map.size() == k) {
                max = Math.max(max, j - i );
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char ch = str.charAt(i);
                    int  v  = map.get(ch) - 1;
                    if (v == 0) {
                        map.remove(ch);
                    } else {
                        map.put(ch, v);
                    }
                    i++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestUniqueCharSize("aabacbebebe", 3));
    }
}
