class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int idx = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx = i;
                break;
            }
        }

        boolean isInc = true;
        boolean isDec = true;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int next = nums[(i + 1) % n];

            if (next != (curr + 1) % n) {
                isInc = false;
            }

            if (next != (curr - 1 + n) % n) {
                isDec = false;
            }
        }

        if (isInc) {
            if (idx == 0) {
                return 0;
            }
            
            return Math.min(idx, n - idx + 2);
        }

        if (isDec) {
            return Math.min((idx + 1) % n + 1, n - idx);
        }

        return -1;
    }
}

// TC: O(n)
// SC: O(1)