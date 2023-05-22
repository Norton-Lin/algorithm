package leetcode_1080;

class Solution {
	//二叉树的每个点，若从根到叶子的值和小于limit,删除该点
	//dfs遍历，计算每个点的路径最大值
    public TreeNode sufficientSubset(TreeNode root, int limit) {
    	if(root == null)
    		return root;
    	int num = dfs(0, root, limit);
    	if(num<limit)
            root = null;
    	return root;
    }
    //当前根结点、根结点的祖先结点们的值
    //返回子节点值的和
    public int dfs(int cur, TreeNode root,int limit)
    {
    	int left = root.val,right = root.val;
    	boolean judge = root.left==null||root.right == null;
        if(root.left==null&&root.right==null)//叶子结点
            return root.val;
    	if(root.left != null)
    	{
    		left += dfs(cur+root.val, root.left, limit);
    		if(left+cur<limit)
    			root.left = null;
    		if(judge)
    			return left;
    	}
    	if(root.right != null)
    	{
    		right += dfs(cur+root.val, root.right, limit);
    		if(right+cur<limit)
    			root.right = null;
    		if(judge)
    			return right;
    	}
    	return Math.max(left, right);
    }
}
/**
 * 
 * 自身调用优化版
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        if (root.left == root.right) // root 是叶子
            // 如果 limit > 0 说明从根到叶子的路径和小于 limit，删除叶子，否则不删除
            return limit > 0 ? null : root;
        if (root.left != null) root.left = sufficientSubset(root.left, limit);
        if (root.right != null) root.right = sufficientSubset(root.right, limit);
        // 如果儿子都被删除，就删 root，否则不删 root
        return root.left == null && root.right == null ? null : root;
    }
}
 *
 */
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
