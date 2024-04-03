package day.leetcode_1379;
/*
 * @lc app=leetcode.cn id=1379 lang=java
 *
 * [1379] 找出克隆二叉树中的相同节点
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
// @lc code=start
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode left = null;
        TreeNode right = null;
        if(original!=target){
            if(original.left!=null)
                left = getTargetCopy(original.left, cloned.left, target);
            if(original.right!=null)
                right = getTargetCopy(original.right, cloned.right, target);
        }
        else 
            left = cloned;
        return left == null?right:left;
    }
}
// @lc code=end

