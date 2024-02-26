package leet.code.top150.easy;

import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    /*
        charMap - maintains the mapping of chars from s -> t
        map -> indicates if a character in 't' is already mapped to a char in 's'

        steps:
        1. if lengths are not equal return false
        2. If char is not present in charMap but map indicates the char is already mapped -> false
        3. If char is present and map indicates the char is mapped to different char -> false
     */
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Character> charMap = new HashMap<>();
        Map<Character, Boolean>   map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ts = t.charAt(i);
            if(!charMap.containsKey(cs)) {
                if(!map.containsKey(ts)) {
                    map.put(ts, true);
                    charMap.put(cs, ts);
                } else {
                    return false;
                }
            } else {
                if(!map.containsKey(ts)) {
                    return false;
                } else {

                    if (charMap.get(cs) != ts) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
