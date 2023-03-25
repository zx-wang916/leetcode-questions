package leetcode.editor.cn;

/**
 * 反转字符串
 * @author Zuxun Wang
 * @date 2023-03-25 22:38:48
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[right]; s[right] = s[left]; s[left] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}