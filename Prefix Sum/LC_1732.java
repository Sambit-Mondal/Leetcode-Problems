class Solution {
    int globalMax;
    int currentMax;

    public int largestAltitude(int[] gain) {
        int n = gain.length;
        currentMax = 0;
        globalMax = 0;

        for (int g : gain) {
            currentMax += g;
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }
}

// TC: O(n)
// SC: O(1)