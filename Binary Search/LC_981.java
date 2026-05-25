class TimeMap {

    private Map<String, List<Integer>> timeMap;
    private Map<String, List<String>> valueMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        valueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
        valueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Integer> timeList = timeMap.get(key);
        List<String> valList = valueMap.get(key);

        int left = 0, right = timeList.size() - 1;
        int resIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (timeList.get(mid) <= timestamp) {
                resIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return resIndex == -1 ? "" : valList.get(resIndex);
    }
}

// TC: O(log n)
// SC: O(n)

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */