# 1. 深度优先遍历

对于类似的岛屿问题，我们可以采用深度优先遍历 DFS 来写，更加的简洁明了。

```java
class Solution {
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int new_color, int origin_color) {
        int m = image.length, n = image[0].length;
        if (sr >= m || sr < 0 || sc >= n || sc < 0 || image[sr][sc] != origin_color) {
            return ;
        }

        image[sr][sc] = new_color;
        for (int i = 0; i < 4; i++) {
            int new_x = sr + dx[i], new_y = sc + dy[i];
            dfs(image, new_x, new_y, new_color, origin_color);
        }
    }
}
```

此处代码有借鉴

https://leetcode.com/problems/flood-fill/solutions/2513930/very-easy-100-fully-explained-java-c-python-javascript-python3-dfs-recursion/

```java
// Runtime: 1 ms, faster than 90.98% of Java online submissions for Flood Fill.
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Avoid infinite loop if the new and old colors are the same...
        if(image[sr][sc] == color) return image;
        // Run the fill function starting at the position given...
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void fill(int[][] image, int sr, int sc, int color, int cur) {
        // If sr is less than 0 or greater equals to the length of image...
        // Or, If sc is less than 0 or greater equals to the length of image[0]...
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        // If image[sr][sc] is not equal to previous color...
        if(cur != image[sr][sc]) return;
        // Update the image[sr][sc] as a color...
        image[sr][sc] = color;
        // Make four recursive calls to the function with (sr-1, sc), (sr+1, sc), (sr, sc-1) and (sr, sc+1)...
        fill(image, sr-1, sc, color, cur);
        fill(image, sr+1, sc, color, cur);
        fill(image, sr, sc-1, color, cur);
        fill(image, sr, sc+1, color, cur);
    }
}
```

但是感觉并没有我写的好。但是他的注释非常详细，不懂的话可以看看。

## 复杂度分析

时间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。

空间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。主要为栈空间的开销。

# 2. 广度优先搜索

当然我们也可以运用广度优先 BFS 来做，这需要用到一个 Queue 来实现。

```java
class Solution {
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        int origin_color = image[sr][sc];
        Queue<int[]> coors = new LinkedList<>();
        coors.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!coors.isEmpty()) {
            int[] coor = coors.poll();
            int x = coor[0], y = coor[1];
            for (int i = 0; i < 4; i++) {
                int new_x = x + dx[i], new_y = y + dy[i];
                if (new_x < image.length && new_x >= 0
                        && new_y < image[0].length && new_y >= 0
                        && image[new_x][new_y] == origin_color) {
                    coors.add(new int[] {new_x, new_y});
                    image[new_x][new_y] = color;
                }
            }
        }
        return image;
    }
}
```

## 复杂度分析

时间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。

空间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。主要为栈空间的开销。