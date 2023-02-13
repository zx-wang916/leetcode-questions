# 1. 根据题意的直觉

Allowed at Most K times of Duplicates

## Complexity

- Time complexity: O(n)
- Space complexity: O(1)

```java
public int removeDuplicates(int[] nums) {
    		//define at most k times of duplicate numbers
    		final int k = 2;

    		//check if it is an empty array
    		if(nums.length == 0) return 0;

    		//start pointer of new array
    		int m = 1;

    		// count the time of duplicate numbers occurence
    		int count = 1;

    		for(int i = 1; i < nums.length; ++i) {
    			if(nums[i] == nums[i - 1]) {
    				if(count < k) {
    					nums[m++] = nums[i];
    				}
    				count++;
    			} else {
    				count = 1;
    				nums[m++] = nums[i];
    			}
    		}
    		return m;
    	}
```

总结：用一个``for``循环来创建新的数组，这个数组的第一个值已经固定，通过比较当前值和前一个值是否相同，以及重复的次数来确认是否添加当前元素至“新建”的数组。

# 2. 光头哥的解法

- Time complexity: O(n)
- Space complexity: O(1)

```java
/* Just go through the numbers and include those in the result that haven't been included twice already */
public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
    return i;
}
```

总结：

- ``i`` 是用于记录插入新数字的位置。前两个数不用考虑是否重复即可插入。

- ``i``和``n``两个指针，一开始齐头并进，同时指向一个位置，当当前的数值不比他前前一个数值大的时候，意味着出现了3个或3个以上的相同值，此时不满足``if``条件。``i``停留在不满足的位置，等待下一个更大的数来替换。
- 当出现下一个更大的数字时再次满足``if``条件，将``i``所指向的位置替换为该数字，``i``指向下一个等待替换，此时``if``条件再次用以检测用来替换的数字，以保证不出现两次以上的重复。