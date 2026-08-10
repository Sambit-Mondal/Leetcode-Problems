class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int n = digits.length();
        
        if (n == 0) {
            return res;
        }

        String[] digMap = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        char[] curr = new char[n];

        backtrack(digits, 0, curr, res, digMap);

        return res;
    }

    private void backtrack (String digits, int i, char[] curr, List<String> res, String[] digMap) {
        if (i == digits.length()) {
            res.add(new String(curr));
            return;
        }

        String str = digMap[digits.charAt(i) - '0'];

        for (int j = 0; j < str.length(); j++) {
            curr[i] = str.charAt(j);
            backtrack(digits, i + 1, curr, res, digMap);
        }
    }
}

// TC: O((4 ^ n) * n)
// SC: O(n) + O(output)