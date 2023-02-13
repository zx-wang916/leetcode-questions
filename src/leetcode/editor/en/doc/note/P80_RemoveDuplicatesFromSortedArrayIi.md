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

总结：用一个for循环来创建新的数组，这个数组的第一个值已经固定，通过比较当前值和前一个值是否相同，以及重复的次数来确认是否添加当前元素至“新建”的数组。