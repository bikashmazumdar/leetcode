package leet.code.top150.easy;

/*
    Ref - https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class FirstOccurance {

    /*
        steps:
            1. if length of needle > haystack the needle can't be part of haystack
            2. i -> 0 to (length(haystack) - length(needle) because in the inside loop we are check i+j
            3. if match is equal to length(needle) then return the index
            4. If match is not found the start from first index of needle, j = 0
     */
    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length() ) return -1;

        for(int i = 0; i <= (haystack.length() - needle.length()); i++) {
            int j = 0;

            while(j < needle.length() && needle.charAt(j) == haystack.charAt(i + j) ) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        FirstOccurance firstOccurance = new FirstOccurance();
        System.out.println(firstOccurance.strStr("sadbutsad", "sad"));
        System.out.println(firstOccurance.strStr("leetcode", "leeto"));
        System.out.println(firstOccurance.strStr("hello", "ll"));
        System.out.println(firstOccurance.strStr("a", "a"));
    }
}
