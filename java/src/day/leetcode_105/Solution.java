/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */
package day.leetcode_105;
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
    //前序遍历第一个是根
    //中序遍历，根前是左子，根后是右子
    //二分查找中序的根
    int count = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[count]);
        int mid = 0;
        while(inorder[mid]!=root.val)
            ++mid;
        root.left = buildTree(preorder, inorder,0,mid-1);
        root.right = buildTree(preorder, inorder,mid+1, inorder.length-1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int left,int right){
        if(count==preorder.length)
            return null;
        int mid = left;
        TreeNode root = new TreeNode(preorder[++count]);
        while(mid<=right&&inorder[mid]!=root.val)
            ++mid;
        if(mid > right){
            --count;
            return null;
        }
        root.left = buildTree(preorder, inorder,left,mid-1);
        root.right = buildTree(preorder, inorder,mid+1, right);
        return root;
    }
}
// @lc code=end
