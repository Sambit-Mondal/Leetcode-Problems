class Solution {
    int m, n;
    int res;
    int nonObstacles;
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        res = 0;
        nonObstacles = 0;

        int start_x = 0;
        int start_y = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    nonObstacles++;
                }

                if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                }
            }
        }

        nonObstacles += 1;

        int count = 0;

        backtrack(grid, count, start_x, start_y);
        
        return res;
    }

    private void backtrack (int[][] grid, int count, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1) {
            return;
        }

        if (grid[i][j] == 2) {
            if (count == nonObstacles) {
                res++;
            }

            return;
        }

        grid[i][j] = -1;

        for (int[] dir : direction) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            backtrack(grid, count + 1, new_i, new_j);
        }

        grid[i][j] = 0;
    }
}

// TC: O(3 ^ (m * n))
// SC: O(m * n)