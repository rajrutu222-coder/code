class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] represents if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Base cases: patterns with '*' can match an empty string s
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char charS = s.charAt(i - 1);
                char charP = p.charAt(j - 1);

                if (charP == '.' || charP == charS) {
                    // Match current single character
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charP == '*') {
                    // Case 1: Treat '*' as matching 0 occurrences of the preceding element
                    dp[i][j] = dp[i][j - 2];

                    // Case 2: If preceding element matches charS, treat '*' as matching 1+ occurrences
                    char prevCharP = p.charAt(j - 2);
                    if (prevCharP == '.' || prevCharP == charS) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}