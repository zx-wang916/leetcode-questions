package leetcode.editor.cn;

/**
 * 填充每个节点的下一个右侧节点指针
 * @author Zuxun Wang
 * @date 2023-05-23 16:57:04
 */
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node pre = root;
        while (pre.left != null) {
            Node temp = pre;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            pre = pre.left;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
