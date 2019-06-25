/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class surroundedRegions30 {

    class Solution {

        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }
            for (int j = 0; j < n; j++) {
                if (!visited[0][j] && board[0][j] == 'O')
                    dfs(board, visited, 0, j, m, n);
                if (!visited[m - 1][j] && board[m - 1][j] == 'O')
                    dfs(board, visited, m-1, j, m, n);
            }
            for (int i = 0; i < m; i++) {
                if (!visited[i][0] && board[i][0] == 'O')
                    dfs(board, visited, i, 0, m ,n);
                if (!visited[i][n - 1] && board[i][n - 1] == 'O')
                    dfs(board, visited, i, n - 1, m, n);
            }
            for (int i = 0; i < m ;i++) {
                for (int j = 0; j < n ; j++) {
                    if (!visited[i][j] && board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }

        private void dfs(char[][] board, boolean[][] visited, int row, int col, int m, int n) {
            visited[row][col] = true;
            if (row - 1 > 0 && !visited[row - 1][col] && board[row - 1][col] == 'O')
                dfs(board, visited, row - 1, col, m, n);
            if (row + 1 < m && !visited[row + 1][col] && board[row + 1][col] == 'O')
                dfs(board, visited, row + 1, col, m, n);
            if (col - 1 > 0 && !visited[row][col - 1] && board[row][col - 1] == 'O')
                dfs(board, visited, row, col - 1, m, n);
            if (col + 1 < n && !visited[row][col + 1] && board[row][col + 1] == 'O')
                dfs(board, visited, row, col + 1, m, n);
        }
    }

    public void run() {
        Solution s = new Solution();
        char[][] a = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] b = {{'O', 'O'}, {'O', 'O'}};
        s.solve(b);
        System.out.println(a);
    }

    public static void main(String[] args) {
        surroundedRegions30 p = new surroundedRegions30();
        p.run();
    }
}

