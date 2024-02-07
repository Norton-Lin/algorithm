/*
 * @lc app=leetcode.cn id=2641 lang=java
 *
 * [2641] 二叉树的堂兄弟节点 II
 */

import java.util.Queue;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
    //结点值换成堂兄弟结点
    //堂兄弟节点：深度相同，父节点不同
    //此树是二叉树
    //层序遍历，一层一层看
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> sums = new ArrayList<>();
        int num = 1;
        int next = 0;
        int sum = 0;
        int count =1;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            sum += cur.val;//记录本层总和
            --num;
            if(num == 0){
                sums.add(sum);
                sum = 0;
                num = next;//下一层节点数量
            }
            if(cur.left!=null){
                queue.add(cur.left);
                ++next;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                ++next;
            }
        }
        queue.offer(root);
        num = 1;
        next = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int temp = 0;
            sum = sums.get(count);
            --num;
            if(cur.left!=null && cur.right!=null){
                temp = cur.left.val + cur.right.val;
                cur.left.val = cur.right.val = sum - temp;
                queue.offer(cur.left);
                queue.offer(cur.right);
                next += 2;
            }else if(cur.left!=null){
                cur.left.val = sum - cur.left.val;
                queue.offer(cur.left);
                ++next;
            }else if(cur.right!=null){
                cur.right.val = sum - cur.right.val;
                queue.offer(cur.right);
                ++next;
            }else{
                cur.left.val = cur.right.val = 0;
                ++num;
            }
            if(num == 0){
                num = next;
                ++count;
            }
        }
        return root;
    }
}
// @lc code=end
