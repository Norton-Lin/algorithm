package day.leetcode_1261;
/*
 * @lc app=leetcode.cn id=1261 lang=java
 *
 * [1261] 在受污染的二叉树中查找元素
 */

import java.util.HashSet;
import java.util.Set;

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

class FindElements {
    TreeNode root;
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        this.root = root;
        this.root.val = 0;
        set.add(root.val);
        if(this.root.left !=null)
            dfs(this.root.left, 1);
        if(this.root.right != null)
            dfs(this.root.right, 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
    public void dfs(TreeNode root, int value){
        root.val = value;
        set.add(root.val);
        if(root.left !=null)
            dfs(root.left, 2*value + 1);
        if(root.right != null)
            dfs(root.right, 2*value + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
// @lc code=end
