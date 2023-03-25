# 快慢指针法

用两个指针 `slow` 与 `fast` 一起遍历链表。`slow` 一次走一步，`fast` 一次走两步。那么当 `fast` 到达链表的末尾时，`slow` 必然位于中间。

## 代码1 （力扣官方）

- 时间复杂度：O(N)，其中 N 是给定链表的结点数目。
- 空间复杂度：O(1)，只需要常数空间存放 slow 和 fast 两个指针。

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/middle-of-the-linked-list/solution/lian-biao-de-zhong-jian-jie-dian-by-leetcode-solut/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

## 代码2 （我的解法 --> 有点绕）

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;
        if (head.next.next == null) return head.next;

        ListNode low_speed = head.next;
        ListNode hi_speed = head.next.next;

        while (hi_speed != null){
            if (hi_speed.next == null) return low_speed;
            if (hi_speed.next != null && hi_speed.next.next == null) return low_speed.next;

            low_speed = low_speed.next;
            hi_speed = hi_speed.next.next;
        }
        return null;
    }
}
```

这种解法是将node的个数分为奇数个和偶数个后分别计算中间值，其实优化后是力扣的解法。