# Eric的解法
时间复杂度在最差的情况下可能达到 O(N^2)。所以不建议使用。但是，他提供了一个很好的思路，在于他通过检查 `HashMap`的 `size`与 `slicing window`的`size`来检测是否出现重复值，对于其他题目的解法可能有所帮助。
请注意，其中 while loop 下嵌套的并非是 `if` 而是 `while`， 请仔细思考原因。
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = 0;
        int maxLen = 0;

        Map<Character, Integer> hm = new HashMap<>();

        while (r < arr.length){
            hm.put(arr[r], hm.getOrDefault(arr[r], 0)+1);

            // check if hashmap has repeated element by checking the length
            // with the size of the slicing window
            while (hm.size() < r - l + 1){
                hm.put(arr[l], hm.get(arr[l]) - 1);
                if (hm.get(arr[l]) == 0){
                    hm.remove(arr[l]);
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
```

# 优化后的解法

## 11-line simple Java solution, O(n) with explanation

the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
```java
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
```