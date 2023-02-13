package leetcode.editor.en;

/**
 * Remove Duplicates from Sorted Array II
 * @author Zuxun Wang
 * @date 2023-02-12 23:27:51
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        // base case
        int n = nums.length;
        if (n < 3) return n;

        final int k = 2;

        int m = 1;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) {
                count = 1;
                nums[m++] = nums[i];
            } else {
                if (count < k) {
                    nums[m++] = nums[i];
                }
                count++;
            }
        }
        return m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}