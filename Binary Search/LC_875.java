class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private int getMax(int[] piles) {
        int max = 0;
        
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        return max;
    }

    private boolean canEatAll(int[] piles, int k, int h) {
        long totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + (long) k - 1) / k;
        }

        return totalHours <= h;
    }
}

// TC: O(n (log (max)))
// SC: O(1)