class Solution {
    int maxCoins;

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        maxCoins = 0;

        for (int cost : costs) {
            if (cost <= 0 || cost > coins) {
                break;
            }

            maxCoins++;
            coins -= cost;
        }

        return maxCoins;
    }
}

// TC: O(n log n)
// SC: O(1)