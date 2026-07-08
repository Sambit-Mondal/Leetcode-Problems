class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        int[] dirRows = {-1, 1, 0, 0};
        int[] dirCols = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    
                    grid[i][j] = '0';

                    Deque<int[]> q = new ArrayDeque<>();
                    q.addLast(new int[]{
                        i, j
                    });

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int rows = curr[0];
                        int cols = curr[1];

                        for (int k = 0; k < 4; k++) {
                            int newRows = rows + dirRows[k];
                            int newCols = cols + dirCols[k];

                            if (newRows >= 0 && newRows < m && newCols >= 0 && newCols < n && grid[newRows][newCols] == '1') {
                                grid[newRows][newCols] = '0';

                                q.addLast(new int[]{
                                    newRows, newCols
                                });
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }
}

// TC: O(m * n)
// SC: O(m * n)