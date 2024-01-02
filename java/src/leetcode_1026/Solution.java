package leetcode_1026;


class TreeNode 
{     int val;
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
    //针对每个结点深度优先？若子节点值比当前父结点大，更新父节点
	//深度优先，维护一个栈，子节点值要和栈内所有元素进行计算
	//太暴力哩
	int ans = 0;
	/**
    public int maxAncestorDiff(TreeNode root) {
    	Stack<Integer> stack = new Stack<>();
    	stack.push(root.val);
    	dfs(stack, root.left);
    	dfs(stack, root.right);
    	return ans;
    }
    public void dfs(Stack<Integer> stack, TreeNode cur){
        if(cur == null)
        	return ;
        int value = 0;
        for(int i: stack)
        {
        	value = Math.abs(i-cur.val);
        	ans = Math.max(ans, value);
        }
        stack.push(cur.val);
        dfs(stack, cur.left);
        dfs(stack, cur.right);
        stack.pop();
    }**/
	//优化一下，每个子节点实际上只需要和所有祖先节点中的最大值最小值进行比较
	public int maxAncestorDiff(TreeNode root) {
		dfs(root.val, root.val, root.left);
		dfs(root.val, root.val, root.right);
		return ans;
	}
	public void dfs(int max,int min, TreeNode cur) {
		if(cur == null)
			return;
		ans = Math.max(Math.abs(max - cur.val), ans);
		ans = Math.max(Math.abs(min - cur.val), ans);
		if(max<cur.val) {
			max = cur.val;
		}
		if(min>cur.val){
			min = cur.val;	
		}
		dfs(max, min, cur.left);
		dfs(max, min, cur.right);
	}
}
