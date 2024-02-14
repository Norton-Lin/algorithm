/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
 */
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        int right = ans.size() - 1;
        int left = 0 ;
        while(left<right){
            List<Integer> i = ans.get(left);
            List<Integer> j = ans.get(right);
            ans.set(left,j);
            ans.set(right, i);
            ++left;
            --right;
        }
        return ans;
    }
}
// @lc code=end

