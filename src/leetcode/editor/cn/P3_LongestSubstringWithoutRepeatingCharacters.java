package leetcode.editor.cn;

/**
 * 无重复字符的最长子串
 * @author Zuxun Wang
 * @date 2023-03-26 22:43:04
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        int maxLen = 0;

        for (int l = 0, r = 0; r < arr.length; r++) {
            if (hm.containsKey(arr[r])) {
                l = Math.max(l, hm.get(arr[r]) + 1);
            }
            hm.put(arr[r], r);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}