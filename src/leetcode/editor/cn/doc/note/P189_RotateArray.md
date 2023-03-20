# 方法一：使用额外的数组
我们可以使用额外的数组来将每个元素放至正确的位置。用 n 表示数组的长度，我们遍历原数组，将原数组下标为 i 的元素放至新数组下标为 (i+k) mod n 的位置，最后将新数组拷贝至原数组即可。

```Java
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
```

## **复杂度分析**

- 时间复杂度： O(n), 其中 n为数组的长度。
- 空间复杂度： O(n)。

# 方法二：数组翻转

根据题意，如果使用多余数组存储空间，会导致空间复杂度为 n，所以在这里，我们可以使用常量级的空间复杂度解法：数组翻转。

思路如下：

1. 首先对整个数组实行翻转，这样子原数组中需要翻转的子数组，就会跑到数组最前面。
2. 这时候，从 k 处分隔数组，左右两数组，各自进行翻转即可。


```java
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
```

## **复杂度分析**

- 时间复杂度：O(n)
- 空间复杂度：O(1)
