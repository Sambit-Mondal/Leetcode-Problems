class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> strMap = new HashMap<>();
        char[] textArr = text.toCharArray();

        for (char t : textArr) {
            strMap.put(t, strMap.getOrDefault(t, 0) + 1);
        }

        int bCount = strMap.getOrDefault('b', 0);
        int aCount = strMap.getOrDefault('a', 0);
        int lCount = strMap.getOrDefault('l', 0) / 2;
        int oCount = strMap.getOrDefault('o', 0) / 2;
        int nCount = strMap.getOrDefault('n', 0);

        return Math.min(bCount, Math.min(aCount, Math.min(lCount, Math.min(oCount, nCount))));
    }
}

// TC: O(n)
// SC: O(1)