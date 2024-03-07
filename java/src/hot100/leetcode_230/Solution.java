package hot100.leetcode_230;
/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    //中序遍历第k个
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        in_order(root, k);
        return ans;
    }
    public int in_order(TreeNode root,int k){
        if(root == null)
            return 0;
        in_order(root.left, k);
        if(count >= k)
            return 0;
        ++count;
        if(count == k){
            ans = root.val;
            return 0;
        }
        in_order(root.right, k);
        return 0;
    }
}
// @lc code=end

