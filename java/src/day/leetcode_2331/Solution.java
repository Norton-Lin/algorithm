package day.leetcode_2331;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

class Solution {
    //0 False 1 True
    //2 Or  3 And
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 1)
            return true;
        else if(root.val == 2)
            return evaluateTree(root.left) || evaluateTree(root.right);
        else if(root.val == 3)
           return evaluateTree(root.left) && evaluateTree(root.right);
        return false;
    }
}
