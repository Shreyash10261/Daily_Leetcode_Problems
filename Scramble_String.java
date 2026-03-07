class Scramble_String  
{
    public boolean isScramble(String s1, String s2) {

        int n = s1.length();
        if(n != s2.length()) return false;

        boolean[][][] dp = new boolean[n + 1][n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for(int len = 2; len <= n; len++) {

            for(int i = 0; i <= n - len; i++) {

                for(int j = 0; j <= n - len; j++) {

                    for(int k = 1; k < len; k++) {

                        boolean noSwap =
                            dp[k][i][j] &&
                            dp[len - k][i + k][j + k];

                        boolean swap =
                            dp[k][i][j + len - k] &&
                            dp[len - k][i + k][j];

                        if(noSwap || swap) {
                            dp[len][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[n][0][0];
    }
}
