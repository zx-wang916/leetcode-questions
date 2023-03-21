package leetcode.editor.cn;

/**
 * 移动零
 * @author Zuxun Wang
 * @date 2023-03-21 19:19:21
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 1;

        while (r < nums.length) {
            if (nums[l] == 0) {
                if (nums[r] == 0){
                    r++;
                } else {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;

                    l ++;
                }
            } else {
                l++;
                r++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}