# 此处两种解法全部来自 力扣

如果不理解的话，请打开链接来获得详情图和动画。

作者：wang_ni_ma
链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 迭代解法

仔细看下完成后的串联树，其连接的方式有两种:
第一种 是这两个串联的节点都有一个共同的父节点，通过父节点就可以将这两个子节点串联起来

第二种 是这两个串联的节点的父节点不同，对于这种情况，如果我们能将这一层的上一层串联好。那么可以通过父节点的next找到邻居，完成串联。

即

```
root.right.next => root.next.left
```

这里我们需要保证 `root.next` 不为空就可以了。
也就是说当我们要串联第 i 层节点时，需要先完成第 i-1 层的节点串联
第一层最多只有一个节点，不需要串联
第二层最多只有两个节点，借助根节点就可以完成串联了
第三层串联时，上一层已经串联完了，所以第三层可以完成串联
同理，可以完成第四层，第五层，第N层的串联

### 代码

```java
class Solution {
	public Node connect(Node root) {
		if(root==null) {
			return root;
		}
		Node pre = root;
		//循环条件是当前节点的left不为空，当只有根节点
		//或所有叶子节点都出串联完后循环就退出了
		while(pre.left!=null) {
			Node tmp = pre;
			while(tmp!=null) {
				//将tmp的左右节点都串联起来
				//注:外层循环已经判断了当前节点的left不为空
				tmp.left.next = tmp.right;
				//下一个不为空说明上一层已经帮我们完成串联了
				if(tmp.next!=null) {
					tmp.right.next = tmp.next.left;
				}
				//继续右边遍历
				tmp = tmp.next;
			}
			//从下一层的最左边开始遍历
			pre = pre.left;
		}
		return root;
	}
}
```

### 复杂度分析

时间复杂度：
O(n)
空间复杂度：
O(1)

## 递归

非常巧妙的一种解法，我们以当前节 root 点为起始，左右节点不断的深入下面，left 节点不断往右走，right 节点不断往左走，当这两个节点走到底后，整个纵深这段就完成了串联。

以从上往下的方向看，1，2，3，5，6这几个节点在位置上都是紧挨着的，同时这几个节点都是左右串联的。

递归函数实现如下：

终止条件：当前节点为空时
函数内：以当前节点为起始，完成从上往下的纵深串联，再递归的调用当前节点 left 和 right

### 代码实现:

```java
class Solution {
	public Node connect(Node root) {
		dfs(root);
		return root;
	}
	
	void dfs(Node root) {
		if(root==null) {
			return;
		}
		Node left = root.left;
		Node right = root.right;
		//配合动画演示理解这段，以root为起点，将整个纵深这段串联起来
		while(left!=null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
		//递归的调用左右节点，完成同样的纵深串联
		dfs(root.left);
		dfs(root.right);
	}
}
```

### 复杂度分析

时间复杂度：O(n)
空间复杂度：O(h)， h 是树的高度