# 解题思路
- 标签：二分查找
- 如果该题目暴力解决的话需要O(n) 的时间复杂度，但是如果二分的话则可以降低到O(logn) 的时间复杂度
- 整体思路和普通的二分查找几乎没有区别，先设定左侧下标 ``left`` 和右侧下标 ``right``，再计算中间下标 ``mid``
- 每次根据 ``nums[mid]`` 和 ``target`` 之间的大小进行判断，相等则直接返回下标，``nums[mid] < target`` 则 ``left`` 右移，``nums[mid] > target`` 则 ``right`` 左移
- 查找结束如果没有相等值则返回 ``left`，该值为插入位置
- 时间复杂度：O(logn)

二分查找的思路不难理解，但是边界条件容易出错，比如 循环结束条件中 left 和 right 的关系，更新 left 和 right 位置时要不要加 1 减 1。

下面给出两个可以直接套用的模板，记住就好了，免除边界条件出错。

```Java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 注意
        while(left <= right) { // 注意
            int mid = (left + right) / 2; // 注意
            if(nums[mid] == target) { // 注意
            	// 相关逻辑
            } else if(nums[mid] < target) {
            	left = mid + 1; // 注意
            } else {
            	right = mid - 1; // 注意
            }
        }
        // 相关返回值
        return 0;
    }
}
```

## 代码

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
            	return mid;
            } else if(nums[mid] < target) {
            	left = mid + 1;
            } else {
            	right = mid - 1;
            }
        }
        return left;
    }
}
```



作者：guanpengchn
链接：https://leetcode.cn/problems/search-insert-position/solution/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。