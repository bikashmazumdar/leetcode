package leet.code.top150.easy;

/*
    https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    private boolean isAlphanumeric(Character c) {
        return Character.isDigit(c) || Character.isAlphabetic(c);
    }
    public boolean isPalindrome(String s) {
        int i = 0 , j = s.length() - 1;
        while (i <= j) {

            if(!isAlphanumeric(s.charAt(i))) {
                i++;
            } else if (!isAlphanumeric(s.charAt(j))) {
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome(s));
    }
}
