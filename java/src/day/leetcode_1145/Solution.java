package day.leetcode_1145;

import java.util.ArrayDeque;
import java.util.Queue;

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
    //谁先到1谁赢
    // 广度优先搜索，先找x结点
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int count = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        TreeNode cur = null;
        while(!queue.isEmpty())
        {
        	cur = queue.poll();
        	if(cur.val == x)
        		break;
        	if(cur.left!=null)
        		queue.add(cur.left);
        	if(cur.right!=null)
        		queue.add(cur.right);
        }
        count = countNode(cur);
        if(count < n -count)
            return false;
        return true;
    }
    public int countNode(TreeNode root)
    {
        if(root!=null)
            return 1+countNode(root.left)+countNode(root.right);
        return 0;
    }
}