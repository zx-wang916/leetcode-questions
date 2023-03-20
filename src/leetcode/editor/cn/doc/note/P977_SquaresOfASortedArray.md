# 1. 暴力解题

Squares of sorted array seems like the easiest problem if you try to solve it in **O(nlogn) **approach

```csharp
class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0;i<nums.length;i++)
        {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
```

最简单的方法就是将数组 nums*nums* 中的数平方后直接排序。

## 复杂度分析

时间复杂度：**O(nlogn)**，其中 n 是数组 nums 的长度。

空间复杂度：**O(logn)**。除了存储答案的数组以外，我们需要 O(logn) 的栈空间进行排序。

# 2. 双指针

The crux over here is that the array is already sorted.
We are comparing the first and last elements because these have the possibility of being the highest element after squaring.
Both the extremes contain the max element (after square ofc), so we insert these elements into the last of the new array to make it sorted.

```cpp
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
```

## 复杂度分析

时间复杂度：O(n)，其中 n 是数组 nums 的长度。

空间复杂度：O(1)。除了存储答案的数组以外，我们只需要维护常量空间。
