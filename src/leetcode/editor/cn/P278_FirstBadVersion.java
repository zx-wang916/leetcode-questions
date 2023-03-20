package leetcode.editor.cn;

/**
 * 第一个错误的版本
 * @author Zuxun Wang
 * @date 2023-03-20 14:58:35
 */
//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) return 1;

        int lo = 1, hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isBadVersion(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}