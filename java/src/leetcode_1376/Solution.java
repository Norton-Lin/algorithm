package leetcode_1376;

import java.util.ArrayList;
import java.util.List;

class Solution {
	//建树，遍历
	 /*
     * @param n	员工总数为n : 0-n-1
     * @param headID 总负责人
     * @param manager	manager[i]是第i个的直属负责人
     * @param informTime	information[i]是通知时间
     * @return
     */
	class TreeNode{
		public int cur;//当前值
		public List<TreeNode> childrenNodes;//子节点
		TreeNode(int val){
			cur = val;
			childrenNodes = new ArrayList<TreeNode>();
		}
	}
	/**
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		TreeNode[] nodes = new TreeNode[n];
		TreeNode root = null;
		for(int i = 0;i<n;++i)
			nodes[i] = new TreeNode(i);
		for(int i = 0;i<n;++i)
		{
			if(manager[i]>-1)
				nodes[manager[i]].childrenNodes.add(nodes[i]);
		}
		root = nodes[headID];
		return ergodic(root, informTime);
    }
	public int ergodic(TreeNode root,int[] informTime)
	{
		int ans = 0;
		if(root.childrenNodes.isEmpty())
			return 0;
		for(TreeNode item:root.childrenNodes)
			ans = Math.max(ans, ergodic(item,informTime));
		return ans+informTime[root.cur];
	}*/
	//树太花空间了，优化一下
	//O(n) O(1)
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (manager[i] < 0) continue;

            // 计算从 i 向上的累加值
            int s = 0, x = i;
            for (; manager[x] >= 0; x = manager[x])
                s += informTime[x];
            // 此时 x 要么是 headID，要么是一个计算过的节点
            s += informTime[x];
            ans = Math.max(ans, s);

            // 记录从 i 向上的每个未被计算的节点值的对应累加值
            for (x = i; manager[x] >= 0;) {
                int t = informTime[x];
                informTime[x] = s;
                s -= t;
                int m = manager[x];
                manager[x] = -1;
                x = m;
            }
        }
        return ans;
    }
}
