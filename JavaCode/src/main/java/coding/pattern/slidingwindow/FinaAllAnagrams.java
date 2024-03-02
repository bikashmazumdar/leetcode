package coding.pattern.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinaAllAnagrams {

    public static List<Integer> allAnagrams(String str, String other) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (char ch : other.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = 0, l = other.length(), count = map.size();

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
                    result.add(i);
                }

                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
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
        System.out.println(allAnagrams("cbaebabacd", "abc"));
    }
}
