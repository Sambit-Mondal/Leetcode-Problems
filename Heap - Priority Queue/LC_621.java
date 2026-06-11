class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        int intervals = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int curr = maxHeap.poll();

                if (curr > 1) {
                    temp.add(curr - 1);
                }

                intervals++;
                cycle--;
            }

            for (int t : temp) {
                maxHeap.offer(t);
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            intervals += cycle;
        }

        return intervals;
    }
}

// TC: O(n log k)
// SC: O(k)