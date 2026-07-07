class Solution {
    private long sum;
    private long x;

    public long sumAndMultiply(int n) {
        sum = 0;
        x = 0;

        for (char c : Integer.toString(n).toCharArray()) {
            if (c != '0') {
                x = x * 10 + c - '0';
                sum += c - '0';
            }
        }

        return (x * sum);
    }
}

// TC: O(log n)
// SC: O(log n)