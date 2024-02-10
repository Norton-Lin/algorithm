package day.leetcode_993;
/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
 */

import java.util.ArrayDeque;
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
    //当x,y是堂兄弟，返回true
    //x,y父节点不能一样
    public boolean isCousins(TreeNode root, int x, int y) {
        int count = 0;
        int num = 1,next = 0;
        boolean judge = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            --num;
            judge = false;
            if(cur.left!=null){
                queue.add(cur.left);
                ++next;
                if(cur.left.val == x||cur.left.val == y){
                    ++count;
                    judge = false;
                }
                    
            }
            if(cur.right!=null){
                queue.add(cur.left);
                ++next;
                if(cur.right.val == x||cur.right.val == y&&judge){
                    ++count;
                    judge = true;
                }
            }
            if(num == 0){
                num = next;
                next = 0;
                if(count > 0)
                    break;
            }
        }
        return count == 2;
    }
}
// @lc code=end

