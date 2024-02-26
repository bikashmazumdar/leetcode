package leet.code.top150.easy;

import java.util.HashSet;
import java.util.Set;

/*
    https://leetcode.com/problems/is-subsequence/
 */
public class Subsequence {

    /*
        DP - approach
     */
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        boolean [][] dp = new boolean[m+1][n+1];

        /* initialization */
        for(int i = 0; i <= m; i++) {
            dp[0][i] = true;
        }

        // main loop
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    /*
        Simple approach
     */

    public boolean isSubsequenceSimple(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < 1) return true;

        int i = 0, j = 0;

        while (j < n && i < m) {
            /* character matching */
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if ( i == m) return true;
        return false;
    }

    public static void main(String[] args) {
        Subsequence sub = new Subsequence();
        System.out.println(sub.isSubsequence("abc", "ahbgdc"));
        System.out.println(sub.isSubsequence("axc", "ahbgdc"));

        System.out.println(sub.isSubsequenceSimple("abc", "ahbgdc"));
        System.out.println(sub.isSubsequenceSimple("axc", "ahbgdc"));
    }
}
