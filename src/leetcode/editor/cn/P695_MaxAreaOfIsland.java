package leetcode.editor.cn;

/**
 * 岛屿的最大面积
 * @author Zuxun Wang
 * @date 2023-03-27 17:07:51
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i], new_y = y + dy[i];
            area += dfs(grid, new_x, new_y);
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
