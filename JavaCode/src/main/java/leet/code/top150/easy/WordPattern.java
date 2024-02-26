package leet.code.top150.easy;

import java.util.HashMap;
import java.util.Map;

/*
    Ref - https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

    /*
        map - used to store the mapping of chars
        flagMap - used to maintain that word is matched to pattern
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Boolean> flagMap = new HashMap<>();
        String [] str = s.split(" ");

        if (pattern.length() != str.length) return false;

        for(int i = 0, j = 0; i < pattern.length(); i++, j++) {
            char cp = pattern.charAt(i);
            String cs = str[j];

            if(" ".equals(cs)) {
                j++;
            }

            if (!map.containsKey(cp)) {
                map.put(cp, cs);
                if (flagMap.containsKey(cs)) {
                    return false;
                }
                flagMap.put(cs, true);
            } else {
                String cm = map.get(cp);
                if(!cs.equals(cm)) {
                    return false;
                }
            }
        }
        return true;
    }
}
