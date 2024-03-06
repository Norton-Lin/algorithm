/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int ans = 0;
    //树直径 子节点中的最大直径 / 两个子树间的深度差
    public int diameterOfBinaryTree(TreeNode root) {
        //dfs(root, 0);
        dfs(root);
        return ans;
    }
    /**
    //记录本节点子树间的最大长度
    public int dfs(TreeNode root, int depth){
        if(root == null)
            return depth - 1;
        int left = dfs(root.left,depth + 1);
        int right = dfs(root.right, depth + 1);
        ans = Math.max(ans,left+right - 2 * depth);
        System.out.println("当前节点");
        System.out.println(root.val);
        System.out.println(ans);
        return Math.max(left, right);
    }*/
    //优化
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        //叶子节点
        if(root.left == null && root.right == null)
            return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans,left + right);
        return Math.max(left,right) + 1;
    }

}
// @lc code=end

