package leet.code.top150.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Ref - https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    /*
        Steps:
            1. If lengths are not equal they can not be anagrams
            2. store the count of each char in a map
            3. the second loop checks if char exists in the map
            4. if char does not exist in the map return false
            5. otherwise decrement the count
            6. if count is 0 then remove the char from the map
            7. return true if map is empty otherwise false
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if ( s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int v = map.get(c) - 1;
            if ( v == 0) {
                map.remove(c);
            } else {
                map.put(c, v);
            }
        }
        return map.isEmpty();
    }

    /*
        simple O(Nlog(N)) solution
        steps:
            1. sort both the strings after converting them to char array
            2. check if they are equal
     */
    public boolean isValidAnagram(String s, String t) {
        char [] sa = s.toCharArray();
        char [] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return new String(sa).equals(new String(ta));
    }

    public static void main(String[] args) {
        ValidAnagram anagram = new ValidAnagram();
        System.out.println(anagram.isAnagram("anagram","nagaram"));
        System.out.println(anagram.isAnagram("rat","cat"));

        System.out.println(anagram.isValidAnagram("anagram","nagaram"));
        System.out.println(anagram.isValidAnagram("rat","cat"));
    }
}
