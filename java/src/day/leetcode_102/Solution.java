/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */
package day.leetcode_102;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> row = new ArrayList<>();
        queue.add(root);
        int count = 1;
        int next = 0;
        while(!queue.isEmpty()){
            --count;
            TreeNode cur = queue.poll();
            if(cur.left!=null){
                queue.add(cur.left);
                ++next;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                ++next;
            }
            row.add(cur.val);
            if(count == 0){
                ans.add(row);
                row = new ArrayList<>();
                count = next;
                next = 0;
            }   
        }
        return ans;
    }
}
// @lc code=end

