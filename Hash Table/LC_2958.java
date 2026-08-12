class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int goodArrayCount = 1;

        for (int right = 0; right < nums.length; right++) {
            int curr = nums[right];
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);

            while (freqMap.get(curr) > k) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                left++;
            }

            goodArrayCount = Math.max(goodArrayCount, right - left + 1);
        }

        return goodArrayCount;
    }
}

// TC: O(n)
// SC: O(n)