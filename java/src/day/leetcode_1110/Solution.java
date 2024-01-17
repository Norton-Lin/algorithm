package day.leetcode_1110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
	//dfs,遍历树
	List<TreeNode> ans;
	HashSet<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	ans = new ArrayList<>();
    	set = new HashSet<>();
    	boolean judge = true;
    	for(int i:to_delete)
    		set.add(i);
    	if(root!=null)
    	{
    		if(!set.contains(root.val))
    		{
    			judge = false;
    			ans.add(root);
    		}
    		dfs(root);
    	}
        return ans;
    }
    //遍历树
    void dfs(TreeNode root)
    {
    	if(root.left!=null)
    	{
    		
    		if(set.contains(root.left.val))
    		{
    			dfs(root.left);
    			root.left = null;
    		}
    		else {
				dfs(root.left);
				if(set.contains(root.val))//当前结点要删除，子节点成为根结点
					ans.add(root.left);
			}
    	}
    	if(root.right!=null)
    	{
    		if(set.contains(root.right.val))
    		{
    			dfs(root.right);
    			root.right = null;
    		}
    		else {
				dfs(root.right);
				if(set.contains(root.val))
					ans.add(root.right);
			}
    	}
    }
}
