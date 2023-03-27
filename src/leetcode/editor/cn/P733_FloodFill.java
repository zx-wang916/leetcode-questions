package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图像渲染
 * @author Zuxun Wang
 * @date 2023-03-27 16:07:48
 */
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    private int[] dx = new int[] {-1, 1, 0, 0};
//    private int[] dy = new int[] {0, 0, -1, 1};
//    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        if (image[sr][sc] == color) return image;
//        dfs(image, sr, sc, color, image[sr][sc]);
//        return image;
//    }
//
//    private void dfs(int[][] image, int sr, int sc, int new_color, int origin_color) {
//        int m = image.length, n = image[0].length;
//        if (sr >= m || sr < 0 || sc >= n || sc < 0 || image[sr][sc] != origin_color) {
//            return ;
//        }
//
//        image[sr][sc] = new_color;
//        for (int i = 0; i < 4; i++) {
//            int new_x = sr + dx[i], new_y = sc + dy[i];
//            dfs(image, new_x, new_y, new_color, origin_color);
//        }
//    }
//}

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
//leetcode submit region end(Prohibit modification and deletion)