/*
 * @lc app=leetcode.cn id=2583 lang=java
 *
 * [2583] 二叉树中的第 K 大层和
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
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
    //层序遍历所有，获得第k大的数据
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sum = new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        long ans = 0;
        long next = 0;//下一层结点数
        long cur = 1;//本层结点数
        queue.add(root);
        long value = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            value+=node.val;
            --cur;
            if(node.left!=null){
                queue.add(node.left);
                ++next;
            }
            if(node.right!=null){
                queue.add(node.right);
                ++next;
            }
            if(cur ==0){
                cur = next;
                next = 0;
                sum.add(value);
                value = 0;
            }
        }
        if(sum.size()<k)
            return -1;
         
    }
}
// @lc code=end
