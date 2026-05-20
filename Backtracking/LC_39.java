class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] c, int target, int index, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < c.length; i++) {
            path.add(c[i]);
            backtrack(c, target - c[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }
}

// TC: O(2^target)
// SC: O(target)