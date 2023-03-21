# 1. 双指针

首先设置首位两个指针。因为给定的数组是按照非递减顺序排列的，所以当首尾指针指向的数之合的数sum

- 小于 target 时，说明需要将左指针向右移，使sum增大。
- 大于 target 时，说明需要将右指针向左移，使sum减小。
- 等于 target 时，则返回下表。

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r){
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else if (sum < target) l++;
            else r--;
        }
        return new int[] {-1, -1};
    }
}
```

## 复杂度分析：

- 时间复杂度：O(N)

# 2. 8行的解法

```csharp
public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
        if (numbers[l] + numbers[r] > target) r--;
        else l++;
    }
    return new int[]{l + 1, r + 1};
}
```



we use `l` and `r` to denote the first index and second index respectively.

When the sum is:

1. smaller than the target:

   we move `l` to the right by 1. we can't make `r` smaller because that's gonna make the sum even smaller.

2. bigger than target:

   move `r` to the left by 1. we can't make `l` bigger because that's gonna make the sum even bigger.

3. equal to the target:

   we found the answer and return.

Since the question said there is **EXACTLY** one solution and didn't provide any info about when there is no valid answer, so we can always assume there is one and only one answer, which means `l` and `r` never across each other.

Another thing to notice is that this array is sorted.

## 如果不只有一种答案

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
        if (numbers[l] + numbers[r] > target) r--;
        else l++;
        if (r == l) return new int[]{};
    }
    return new int[]{l + 1, r + 1};
    }
}
```

You are correct. But for this specific problem they have asked us to assume that there will always be exactly **1 solution**. And scenario you are pointing out is for the case when there is no solution (i.e. **0 solutions**) which is not possible for this problem.