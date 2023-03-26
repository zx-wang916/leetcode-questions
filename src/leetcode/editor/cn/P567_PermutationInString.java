package leetcode.editor.cn;

/**
 * 字符串的排列
 * @author Zuxun Wang
 * @date 2023-03-26 23:00:42
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean allZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) { return false; }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] count_map = new int[26];
        for (int i = 0; i < n; i++) {
            count_map[s1.charAt(i) - 'a']--;
            count_map[s2.charAt(i) - 'a']++;
        }
        if (allZero(count_map)) return true;

        for (int i = n; i < m; i++) {
            count_map[s2.charAt(i) - 'a']++;
            count_map[s2.charAt(i - n) - 'a']--;
            if (allZero(count_map)) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}