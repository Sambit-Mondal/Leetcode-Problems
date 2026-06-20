class Solution {
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();

        List<String> curr = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        backtrack(s, 0, curr, res);

        return res; 
    }

    private void backtrack(String s, int idx, List<String> curr, List<List<String>> res) {
        if (idx == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}

// TC: O((2 ^ n) * n)
// SC: O(n)