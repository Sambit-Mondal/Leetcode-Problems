class Solution {
    int m, n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, int idx, String word) {
        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$') {
            return false;
        }

        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for (int[] direction : directions) {
            int new_i = i + direction[0];
            int new_j = j + direction[1];

            if (backtrack(board, new_i, new_j, idx + 1, word)) {
                return true;
            }
        }

        board[i][j] = temp;
        
        return false;
    }
}

// TC: O(m * n * (3 ^ l)) [l = length of word]
// SC: O(l)