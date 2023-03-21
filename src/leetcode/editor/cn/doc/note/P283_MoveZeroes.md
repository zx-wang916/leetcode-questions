# 1. 我的解法：双指针

通过两个指针，``l``, ``r``分别从 0 和 1 开始。

- 当左指针指向的值为0时，右指针向后遍历直到找到第一个不为0的数，然后交换值。
- 当左指针指向的值不为0时，左右指针分别向后移一位。

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 1;

        while (r < nums.length) {
            if (nums[l] == 0) {
                if (nums[r] == 0){
                    r++;
                } else {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;

                    l ++;
                }
            } else {
                l++;
                r++;
            }
        }
    }
}
```

## 复杂度分析

- 时间复杂度：O(N)

- 空间复杂度：O(1)

# 2. 滚雪球（有意思）

THE EASIEST but UNUSUAL snowball JAVA solution BEATS 100% (O(n)) + clear explanation

```java
class Solution {
     public void moveZeroes(int[] nums) {
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
}
```

REF: https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-solution-beats-100-o-n-clear-explanation/?orderBy=most_votes

# 3. 循环中插入

Shift non-zero values as far forward as possible

Fill the remaining space with zeros

```java
// Shift non-zero values as far forward as possible
// Fill remaining space with zeros

public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
```

## 复杂度分析

- 时间复杂度：O(N)

- 空间复杂度：O(1)

## 优化后的代码

What we are trying to do here is to shift the number to the left by `m` places. This is because the number of zeroes is m.

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int m=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                m++;
            } else if(m!=0){
                nums[i-m]=nums[i];
                nums[i]=0;
            }
        }            
    }
}
```

