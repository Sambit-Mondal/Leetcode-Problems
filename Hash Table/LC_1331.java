class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rankList = new HashMap<>();
        int rank = 1;

        for (int elem : sortedArr) {
            if (!rankList.containsKey(elem)) {
                rankList.put(elem, rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankList.get(arr[i]);
        }

        return arr;
    }
}

// TC: O(n log n)
// SC: O(n)