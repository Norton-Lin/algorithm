/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        backOrder(root);
        return ans;
    }
    public void backOrder(TreeNode root){
        if(root == null)
            return;
        backOrder(root.left);
        backOrder(root.right);
        ans.add(root.val);
    }
}
// @lc code=end

