# 非常简单的双指针反转数组

对于长度为 N 的待被反转的字符数组，我们可以观察反转前后下标的变化，假设反转前字符数组为 ``s[0] s[1] s[2] ... s[N - 1]``，那么反转后字符数组为 ``s[N - 1] s[N - 2] ... s[0]``。比较反转前后下标变化很容易得出 ``s[i]`` 的字符与 ``s[N - 1 - i]`` 的字符发生了交换的规律，因此我们可以得出如下双指针的解法：

- 将 ``left`` 指向字符数组首元素，``right`` 指向字符数组尾元素。
- 当 ``left`` < ``right``：
	- 交换 ``s[left]`` 和 ``s[right]``；
	- ``left`` 指针右移一位，即 ``left = left + 1``；
	- ``right`` 指针左移一位，即 ``right = right - 1``。
- 当 ``left >= right``，反转结束，返回字符数组即可。

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 代码

### Version 1

```java
class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;

        while (l < r) {
            char temp = s[r];
            s[r] = s[l];
            s[l] = temp;

            l ++;
            r --; 
        }
    }
}
```

### Version 2

```java
class Solution {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[right]; s[right] = s[left]; s[left] = temp;
        }
    }
}
```

## 复杂度分析

- 时间复杂度：O(N)，其中 N 为字符数组的长度。一共执行了 N/2 次的交换。
- 空间复杂度：O(1)。只使用了常数空间来存放若干变量。
