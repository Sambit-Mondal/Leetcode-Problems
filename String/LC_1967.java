class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }
}

// TC: O(n * m) [n = number of 'patterns', m = length of 'word']
// SC: O(1)