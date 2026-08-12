class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        if (m == 0) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid, visited, m, n, i, j);

                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        return maxArea;
    }

    private int dfs (int[][] grid, boolean[][] visited, int m, int n, int sr, int sc) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        stack.push(new int[] {
            sr, sc
        });

        visited[sr][sc] = true;
        int area = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int row = curr[0];
            int col = curr[1];
            area++;

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 1) {
                    visited[nr][nc] = true;

                    stack.push(new int[] {
                        nr, nc
                    });
                }
            }
        }

        return area;
    }
}

// TC: O(m * n)
// SC: O(m * n)