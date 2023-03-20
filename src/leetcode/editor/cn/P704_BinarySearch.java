package leetcode.editor.en;

/**
 * Binary Search
 * @author Zuxun Wang
 * @date 2023-03-20 14:43:54
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}