package leet.code.top150.easy;

import java.util.HashMap;
import java.util.Map;

/*
   ref. https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

    /*
         loop 1 -> store the occurences of magazine in a HashMap
         loop 2 -> decrement the count for matching char until count is > 0
         finally -> checked if count of characters is equals to the length of ransomNote
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int len = 0;
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                int v = map.get(c) - 1;

                if (v >= 0) {
                    len++;
                }

                if (v == 0) {
                    map.remove(c);
                } else {
                    map.put(c, v);
                }
            }
        }
        return ransomNote.length() == len;
    }

    public static void main(String[] args) {
        RansomNote note = new RansomNote();
        System.out.println(note.canConstruct("aa", "aab"));
    }
}
