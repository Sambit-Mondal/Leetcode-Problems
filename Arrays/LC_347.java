class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}

// TC: O(n)
// SC: O(n)