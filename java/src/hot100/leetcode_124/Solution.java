package hot100.leetcode_124;
/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    //自底向上返回路径总和
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        ans = root.val;//只有根节点
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int cur = root.val;
        if(left > 0)//子路径>0 有意义
            cur += left;
        if(right > 0)
            cur += right;
        ans = Math.max(cur, ans);
        if(left < 0 && right < 0)//子节点路径和为0，就不在添加
            return root.val;
        return Math.max(left, right) + root.val;
    }
}
// @lc code=end
