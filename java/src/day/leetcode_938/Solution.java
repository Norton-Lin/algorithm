package day.leetcode_938;
/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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
    /**
    List<Integer> list = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        inorder(root);
        for(int i:list){
            if(i<low)
                continue;
            if(i>high)
                break;
            ans+=i;
        }
        return ans;
    }
    //中序
    public void inorder(TreeNode root){
        if(root.left!=null)
            inorder(root.left);
        list.add(root.val);
        if(root.right!=null)
            inorder(root.right);
    }*/
    //优化
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high){
        inorder(root, low, high);
        return ans;
    }
    public void inorder(TreeNode root, int low, int high){
        if(root == null)
            return;
        if(root.val<low)
            inorder(root.right, low, high);
        else if(root.val>high)
            inorder(root.left, low, high);
        else{
            ans+=root.val;
            inorder(root.left, low, high);
            inorder(root.right, low, high);
        }
    }
}
// @lc code=end

