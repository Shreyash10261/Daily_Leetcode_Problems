class Solution {
     int[][][] dp;
    public int minimumDistance(String word) {
         int n = word.length();
        dp = new int[n][27][27];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 27; j++)
                for (int k = 0; k < 27; k++)
                    dp[i][j][k] = -1;

        return solve(word, 0, 26, 26);
    }

    private int solve(String w, int i, int f1, int f2) {
        if (i == w.length()) return 0;

        if (dp[i][f1][f2] != -1) return dp[i][f1][f2];

        int curr = w.charAt(i) - 'A';

        int a = dist(f1, curr) + solve(w, i + 1, curr, f2);
        int b = dist(f2, curr) + solve(w, i + 1, f1, curr);

        return dp[i][f1][f2] = Math.min(a, b);
    }

    private int dist(int a, int b) {
        if (a == 26) return 0;
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}
