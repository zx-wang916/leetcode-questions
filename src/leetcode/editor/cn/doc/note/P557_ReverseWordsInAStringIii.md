# 1. 使用StringBuffer （额外空间）

思路与算法

开辟一个新字符串。然后从头到尾遍历原字符串，直到找到空格为止，此时找到了一个单词，并能得到单词的起止位置。随后，根据单词的起止位置，可以将该单词逆序放到新字符串当中。如此循环多次，直到遍历完原字符串，就能得到翻转后的结果。

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/reverse-words-in-a-string-iii/solution/fan-zhuan-zi-fu-chuan-zhong-de-dan-ci-iii-by-lee-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 代码

```java
class Solution {
    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
```

## 复杂度分析

- 时间复杂度：O(N)，其中 N 为字符串的长度。原字符串中的每个字符都会在O(1) 的时间内放入新字符串中。
- 空间复杂度：O(N)。我们开辟了与原字符串等大的空间。

虽然时间复杂度不高，但是因为``StringBuffer``加锁，影响效率，所以可以优化。

# 2. 原地解法

优化后的解法，超过100%Java题解。复杂度与第一种解法相同。

## 代码

```java
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
```

把字符串转成字符数组，遍历字符数组；
我们只关心空格字符和最后一个字符，于是，遇到正常的字母字符一概不管；
当遇到空格字符，就需要对刚刚遍历过的单词进行反转操作，此单词的右索引是 ``i - 1``，如何获取左索引？定义一个``int``变量``start``，用来记录单词的左索引；
利用字符数组前后交换字符位置的方法进行反转操作；反转结束后，把``start``索引置为 ``i + 1``，指向下一个单词的开头；
遍历继续，直到遇到下一个空格字符或结尾；
到了字符数组结尾，那么最后一个单词的开头和结束索引分别是 ``start`` 和 ``n - 1``，利用这两个索引进行单词翻转；
最后用``String``的构造方法，将``char``数组转成答案返回。

作者：windmajor
链接：https://leetcode.cn/problems/reverse-words-in-a-string-iii/solution/yi-ci-bian-li-chao-jian-dan-jie-ti-si-lu-2h8s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。