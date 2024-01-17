/*
 * @lc app=leetcode.cn id=1038 lang=java
 *
 * [1038] 从二叉搜索树到更大和树
 */
package day.leetcode_1038;
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // 自底向上，值为右子树最大值+本结点的值
    // 反向中序遍历，先右后左
    // 从后往前叠加
    //只有右叶子节点需要加父节点传递来的数据
    public TreeNode bstToGst(TreeNode root) {
        root.val += ergodic(root.right,0);
        ergodic(root.left,root.val);
        return root;
    }

    public int ergodic(TreeNode root,int num) {
        if(root == null)
            return 0;
        int cur = ergodic(root.right, num);
        if(cur == 0)
            root.val +=num;
        root.val += cur;
        return Math.max(ergodic(root.left, root.val),root.val);
    }
}
// @lc code=end
