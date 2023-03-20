package leetcode.editor.cn;

/**
 * 搜索插入位置
 * @author Zuxun Wang
 * @date 2023-03-20 15:23:41
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}