package coding.pattern.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountAnagramOccurances {

    public static int anagrams(String str, String other) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : other.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = 0, l = other.length(), count = map.size(), result = 0;

        while (j < str.length()) {
            char c = str.charAt(j);
            j++;
            if (map.containsKey(c)) {
                int v = map.get(c) - 1;
                if ( v == 0) {
                    count--;
                }
                map.put(c, v);
            }
            if(j - i  == l) {
                if (count == 0) {
                    result++;
                }
                char ch = str.charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    if (map.get(str.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(anagrams("forxxxrofxxorfxx", "for"));
        System.out.println(anagrams("cbaebabacd", "abc"));
    }
}
