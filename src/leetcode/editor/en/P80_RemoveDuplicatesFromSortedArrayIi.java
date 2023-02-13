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

        // change k to any nums that >=1
        final int k = 2;

        int m = 1;  // pointer for new array
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) {
                count = 1;
                nums[m++] = nums[i];
            } else {
                if (count < k) {
                    nums[m++] = nums[i];
                }
                count++; // increment count after checking,
                         // as count was initialised to be 1.
            }
        }
        return m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}