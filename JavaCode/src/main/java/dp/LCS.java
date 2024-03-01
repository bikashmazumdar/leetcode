package dp;

public class LCS {

    public static int lcs(String s, String r, int sl, int rl) {
        if (sl == 0 || rl == 0) return 0;

        if(s.charAt(sl - 1) == r.charAt(rl - 1)) {
            return 1 + lcs(s, r, sl - 1, rl - 1);
        }
        return Math.max(lcs(s,r, sl, rl - 1), lcs(s,r,sl - 1, rl));
    }

    public static int lcsDP(String s, String r) {
        int sl = s.length() , rl = r.length();
        int [][] dp = new int[sl + 1][rl + 1];

        for(int i = 0; i <= sl; i++) {
            dp[i][0] = 0;
        }

        for(int j = 0; j <= rl; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i <= sl; i++) {
            for (int j = 1; j <= rl; j++) {
                if (s.charAt(i-1) == r.charAt(j -1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        for(int i = 0; i <= sl; i++) {
            for (int j = 0; j <= rl; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[sl][rl];
    }

    public static void main(String[] args) {
        System.out.println(lcs("abc", "aebff", 3, 5));
        System.out.println(lcsDP("abc", "abc"));

        String str = "sgbcba";
        StringBuilder builder = new StringBuilder(str);

        System.out.println("Longest pal sub => " +
                            lcsDP(str, builder.reverse().toString()));

        str = "abcbabf";
        builder = new StringBuilder(str);
        int ls  = lcsDP(str, builder.reverse().toString());
        System.out.println("Min del: " + (str.length() - ls));

    }
}
