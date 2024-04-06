package day.leetcode_1026;
/*
 * @lc app=leetcode.cn id=1026 lang=java
 *
 * [1026] 节点与其祖先之间的最大差值
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
class Solution1 {
    //维护祖先中的最大最小值
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root.left,root.val,root.val);
        dfs(root.right,root.val,root.val);
        return ans;
    }
    public void dfs(TreeNode root, int max, int min){
        if(root == null)
            return;
        int value1 = Math.abs(max-root.val);
        int value2 = Math.abs(min-root.val);
        ans = Math.max(Math.max(value1,value2),ans);
        dfs(root.left,Math.max(root.val,max),Math.min(root.val,min));
        dfs(root.right,Math.max(root.val,max),Math.min(root.val,min));
    }
}
// @lc code=end
