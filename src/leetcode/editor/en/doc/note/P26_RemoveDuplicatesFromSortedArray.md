# 1. 循环解法

## Approach

By iterating through the array and checking if `nums` at the current index `i` is less than `nums` at `i + 1`, we can find an index for all unique numbers in the array. We can then insert each of these numbers to the beginning of the array, at `addIndex`. `addIndex` starts at 1 as the first element in the array is always unique.

## Complexity

- Time complexity: O(n)
- Space complexity: O(1)

## Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int addIndex = 1; //index that unique characters will be inserted at

        for(int i = 0; i < nums.length - 1; i++) {
            
            if(nums[i] < nums[i + 1]){ //if true, num[i + 1] is a new unique number
              nums[addIndex] = nums[i + 1];
              addIndex++;
            }
        }
        return addIndex;
    }
}

```

## Comment

很好理解，而且很容易去做。属于有优化的暴力解法。

# 2. 双指针

## Approach

两个pointers分别在list的0, 1位置。对于长度大于等于2的list，当右指针在[1, nums.length]时，检测左右指针所指向的数是否相同：

- 如果相同，那么只需要右指针向右一位。
- 如果不同，那么就将左指针所指向的下一个数更新为当前右指针所指向的数，并将右指针向右一位。

## Complexity

- Time complexity: O(n)
- Space complexity: O(1)

## Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1;

        // base case
        // empty list or list only contain 1 element.
        if (nums.length < 2) return nums.length;

        while (r < nums.length) {
            if (nums[l] == nums[r]) r++;
            else nums[++l] = nums[r++];
        }

        return l + 1;
    }
}
```

## Comment

代码逻辑清晰，且非常整洁。 仅仅6行就可以将题目解决。