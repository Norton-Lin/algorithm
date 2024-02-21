/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

import java.util.HashMap;
import java.util.Map;

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
    //后序遍历先子后根
    int count = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        count = postorder.length-1;
        TreeNode root = new TreeNode(postorder[count]);
        int mid = 0;
        while(inorder[mid]!=root.val)
            ++mid;
        root.right = buildTree(postorder, inorder,mid+1, inorder.length-1);
        root.left = buildTree(postorder, inorder,0,mid-1);
        return root;
    }
    public TreeNode buildTree(int[] postorder, int[] inorder, int left,int right){
        if(count==0)
            return null;
        int mid = left;
        TreeNode root = new TreeNode(postorder[--count]);
        while(mid<=right&&inorder[mid]!=root.val)
            ++mid;
        if(mid > right){
            ++count;
            return null;
        }
        root.right = buildTree(postorder, inorder,mid+1, right);
        root.left = buildTree(postorder, inorder,left,mid-1);
        
        return root;
    }
}
// @lc code=end
