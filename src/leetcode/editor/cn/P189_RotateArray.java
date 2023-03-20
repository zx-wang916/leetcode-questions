package leetcode.editor.cn;

/**
 * 轮转数组
 * @author Zuxun Wang
 * @date 2023-03-20 17:48:03
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}