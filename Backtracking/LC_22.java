class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        backtrack("", 0, 0, n, res, stack);

        return res;
    }

    private void backtrack(String curr, int openCount, int closeCount, int n, List<String> res, Stack<Character> stack) {
        if (curr.length() == n * 2) {
            res.add(curr);
            return;
        }

        if (openCount < n) {
            stack.push('(');
            backtrack(curr + '(', openCount + 1, closeCount, n, res, stack);
            stack.pop();
        }

        if (closeCount < openCount) {
            stack.push(')');
            backtrack(curr + ')', openCount, closeCount + 1, n, res, stack);
            stack.pop();
        }
    }
}

// TC: O(2 ^ (2 ^ n))
// SC: O(n)