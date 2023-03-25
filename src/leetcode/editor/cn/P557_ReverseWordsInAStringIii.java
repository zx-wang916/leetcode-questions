package leetcode.editor.cn;

/**
 * 反转字符串中的单词 III
 * @author Zuxun Wang
 * @date 2023-03-25 22:55:05
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverse(char[] s, int start, int end) {
        for (int left = start, right = end; left < right; left++, right--) {
            char temp = s[right]; s[right] = s[left]; s[left] = temp;
        }
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }

            if (i == arr.length - 1) {
                reverse(arr, start, i);
            }
        }
        return String.valueOf(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}