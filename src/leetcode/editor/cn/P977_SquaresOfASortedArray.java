package leetcode.editor.cn;

/**
 * 有序数组的平方
 * @author Zuxun Wang
 * @date 2023-03-20 16:51:24
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int curr_index = nums.length - 1;

        int[] res = new int[nums.length];
        while (l <= r) {
            if (Math.abs(nums[l]) < Math.abs(nums[r])) {
                res[curr_index] = nums[r] * nums[r];
                r --;
            } else {
                res[curr_index] = nums[l] * nums[l];
                l ++;
            }
            curr_index --;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}