# 滑动窗口
1. How do we know string `p` is a permutation of string `s`? Easy, each character in `p` is in `s` too. So we can abstract all permutation strings of `s` to a map (Character -> Count). i.e. `abba` -> `{a:2, b:2}`. Since there are only 26 lower case letters in this problem, we can just use an array to represent the map.
2. How do we know string `s2` contains a permutation of `s1`? We just need to create a sliding window with length of `s1`, move from beginning to the end of `s2`. When a character moves in from right of the window, we subtract `1` to that character count from the map. When a character moves out from left of the window, we add `1` to that character count. So once we see all zeros in the map, meaning equal numbers of every characters between `s1` and the substring in the sliding window, we know the answer is true.

```java
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
```

力扣官方的双指针题解有点复杂，在此不做要求。但是上述的代码要掌握！