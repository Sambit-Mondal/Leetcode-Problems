class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int qLen = queries.length;
        int[] component = new int[n];

        int val = 0;
        component[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                val++;
            }

            component[i] = val;
        }

        boolean[] ans = new boolean[qLen];

        for (int i = 0; i < qLen; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            ans[i] = component[u] == component[v];
        }

        return ans;
    }
}

// TC: O(n + q)
// SC: O(n)