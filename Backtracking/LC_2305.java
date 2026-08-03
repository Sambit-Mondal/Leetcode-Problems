import java.util.Arrays;

class Solution {
    private int result = Integer.MAX_VALUE;

    private void solve(int idx, int[] cookies, int[] children, int k) {
        if (idx == cookies.length) {
            int ans = 0;

            for (int child : children) {
                ans = Math.max(ans, child);
            }
            
            result = Math.min(result, ans);
            return;
        }

        int candy = cookies[idx];
        
        for (int i = 0; i < k; i++) {
            if (children[i] + candy >= result) {
                continue;
            }

            children[i] += candy;
            solve(idx + 1, cookies, children, k);
            children[i] -= candy;

            if (children[i] == 0) {
                break;
            }
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        int[] reversedCookies = new int[cookies.length];
        
        for (int i = 0; i < cookies.length; i++) {
            reversedCookies[i] = cookies[cookies.length - 1 - i];
        }

        int[] children = new int[k];
        solve(0, reversedCookies, children, k);
        return result;
    }
}

// TC: O(k ^ n) [k = No. of cookies]
// SC: O(n + k)