package leetcode.editor.cn;

/**
 * 两数之和 II - 输入有序数组
 * @author Zuxun Wang
 * @date 2023-03-21 20:45:12
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r){
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else if (sum < target) l++;
            else r--;
        }
        return new int[] {-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}