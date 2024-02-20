package day.leetcode_103;
/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> row = new ArrayList<>();
        int count = 1;
        int next = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            --count;
            TreeNode cur = queue.poll();
            row.add(cur.val);
            if(cur.left!=null){
                ++next;
                queue.add(cur.left);
            }
            if(cur.right!=null){
                ++next;
                queue.add(cur.right);
            }
            if(count == 0){
                count = next;
                next = 0;
                if(ans.size()%2==1)
                    Collections.reverse(row);
                ans.add(row);
                row = new ArrayList<>();
            }
        }
        return ans;
    }
}
// @lc code=end

