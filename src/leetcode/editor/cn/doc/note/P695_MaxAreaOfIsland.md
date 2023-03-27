# 沉岛思想的DFS

超级简单的DFS思想。也叫做沉岛思想。可以解决任何此类问题

```java
class Solution {
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
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
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 0) {
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
```

借鉴自作者：mark-42，但是有所更改。
链接：https://leetcode.cn/problems/max-area-of-island/solution/biao-zhun-javadong-tai-gui-hua-jie-fa-100-by-mark-/