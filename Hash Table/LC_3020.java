class Solution {
    private int globalMax;

    public int maximumLength(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }

        globalMax = 0;

        if (countMap.containsKey(1)) {
            int ones = countMap.get(1);
            globalMax = (ones % 2 == 1) ? ones : ones - 1;
        }

        for (int count : countMap.keySet()) {
            if (count == 1) {
                continue;
            }

            int currMax = 0;
            long x = count;

            while (countMap.containsKey((int) x) && countMap.get((int) x) >= 2) {
                currMax += 2;
                x = x * x;
            }

            if (countMap.containsKey((int) x)) {
                currMax += 1;
            } else {
                currMax -= 1;
            }

            globalMax = Math.max(globalMax, currMax);
        }

        return globalMax;
    }
}

// TC: O(n)
// SC: O(n)