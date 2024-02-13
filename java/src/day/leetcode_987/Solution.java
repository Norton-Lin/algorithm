/*
 * @lc app=leetcode.cn id=987 lang=java
 *
 * [987] 二叉树的垂序遍历
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
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
    //左右结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 
    //从col最小的点开始
    //自上而下
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int b[]){
                if(a[2] != b[2] )
                    return a[2] - b[2];
                else{
                    if(a[1] != b[1])
                        return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        dfs(queue, 0, 0, root);
        while(!queue.isEmpty()){
            int value = queue.peek()[2];
            List<Integer> col = new ArrayList<>();
            while(!queue.isEmpty()){
                int[] cur = queue.peek();
                if(cur[2]!=value)
                    break;
                col.add(cur[0]);
                queue.poll();
            }
            ans.add(col);
        }
        return ans;

    }
    public void dfs(PriorityQueue<int[]> queue , int row, int col, TreeNode root){
        if(root == null)
            return ;
        queue.add(new int[]{root.val, row, col});
        dfs(queue, row + 1 ,col - 1, root.left);
        dfs(queue, row + 1, col + 1, root.right);
    }
}
// @lc code=end

