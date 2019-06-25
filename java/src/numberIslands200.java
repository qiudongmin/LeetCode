/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class numberIslands200 {

    class Solution {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
                return 0;
            int res = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1')
                        res += (dfs(grid, i, j, rows, cols) ? 1 : 0);
                }
            }
            return res;
        }

        private boolean dfs(char[][] grid, int row, int col, int rows, int cols) {
            if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0')
                return false;
            grid[row][col] = '0';
            boolean res = true;
            for (int[] direction : directions) {
                dfs(grid, row + direction[0], col + direction[1], rows, cols);
            }
            return true;
        }
    }

    public void run() {
        Solution s = new Solution();
        char[][] a = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(s.numIslands(a));
    }

    public static void main(String[] args) {
        numberIslands200 p = new numberIslands200();
        p.run();
    }
}

