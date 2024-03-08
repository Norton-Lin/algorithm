package hot100.leetcode_437;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */
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
    //深搜，自上而下，如何记录？
    //链表
    //注意越界
    int sum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        List<Long> record = new ArrayList<>();
        dfs(root, targetSum, record);
        return sum;
    }
    public void dfs(TreeNode root, int targetSum, List<Long> record){
        if(root == null)
            return;
        List<Long> tmp = record;  
        for(int i=0;i<record.size();++i){
            tmp.set(i, (long)tmp.get(i)+(long)root.val);
            if(tmp.get(i) == targetSum)
                ++sum;
        }
        tmp.add((long)root.val);
        if(root.val == targetSum)
            ++sum;
        dfs(root.left, targetSum, tmp);
        dfs(root.right, targetSum, tmp);
    }
}
// @lc code=end

