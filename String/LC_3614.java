class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] L = new long[n];
        long currLen = 0;
        
        long LIMIT = 1000000000000000L + 100005L + 2L;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                currLen++;
            } else if (ch == '*') {
                if (currLen > 0) currLen--;
            } else if (ch == '#') {
                if (currLen > LIMIT / 2) {
                    currLen = LIMIT;
                } else {
                    currLen *= 2;
                }
            } else if (ch == '%') {
                currLen = currLen;
            }
            L[i] = currLen;
        }

        if (k < 0 || k >= L[n - 1]) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long L_prev = (i > 0) ? L[i - 1] : 0;

            if (ch >= 'a' && ch <= 'z') {
                if (k == L_prev) {
                    return ch;
                }
            } else if (ch == '#') {
                if (k >= L_prev) {
                    k -= L_prev;
                }
            } else if (ch == '%') {
                k = L_prev - 1 - k;
            }
        }

        return '.';
    }
}


// TC: O(n)
// SC: O(n)