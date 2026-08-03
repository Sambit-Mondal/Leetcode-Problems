class Solution {
    static final String[] s = { "Bob", "Tie", "Alice" };

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = { 0, 0, 0, 0 };

        for (int i = n - 1; i >= 0; i--) {
            dp[i & 3] = Integer.MIN_VALUE;
            int sum = 0;

            for (int j = 1; j <= 3 && i + j <= n; j++) {
                sum += stoneValue[i + j - 1];
                dp[i & 3] = Math.max(dp[i & 3], sum - dp[(i + j) & 3]);
            }
        }

        return s[Integer.signum(dp[0]) + 1];
    }
}

// TC: O(n)
// SC: O(1)