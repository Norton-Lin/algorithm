package leetcode_1377;

import java.util.Arrays;


class Solution {
    //n跳后的所有结果
    //每次只能去未访问过的结点（若无则原地不动）
    //是否能跳到目标结果
    //能跳到就是1/x，否则就是0
    public double frogPosition(int n, int[][] edges, int t, int target) {
        double sum = 0;
        int[][] map = new int[n+1][n+1];
        boolean[] tag = new boolean[n+1];//标记，防止循环
        Arrays.fill(tag, true);
        for(int i = 0;i<=n;++i)
            Arrays.fill(map[i], 0);
        for(int i = 0;i<edges.length;++i)
        {
        	map[edges[i][0]][edges[i][1]] = 1;
            map[edges[i][1]][edges[i][0]] = 1;
        }
        tag[1] = false;
        sum+=dfs(map, target, t,1, tag);

        //if(Math.abs(ans)<1e-6)
            //return 0;
        return sum;
    }
    /**
     * 
     * @param map 路径表
     * @param target 目标点
     * @param t 剩余跳数
     * @param cur 当前点位
     * @return
     */
    double dfs(int[][] map, int target, int t, int cur, boolean[] tag)
    {
    	if(t == 0)
    	{
    		if(cur == target)
            {
                //ans = 1;
                return 1;
            }
    		return 0;
    	}
    	double sum = 0;
        double count =0;
    	for(int i = 1;i<map.length;++i)
    	{
    		if(map[cur][i] == 1 && tag[i])
            {
                ++count;
                //只有到target的sum不为0，算得此时的概率
                tag[i] = false;
                sum=Math.max(sum,dfs(map, target, t-1, i,tag));
            }
    			
    	}
        if(Math.abs(count)<1e-6)
        {
            count = 1;
            //到达target，不跳转
            if(cur == target)
                sum = 1;
        }
    	return sum*(1/count);
    }
    public static void main(String args[]) {
		Solution solution = new Solution();
		int[][] edges = new int[][] {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
		double ans = solution.frogPosition(7, edges, 2, 4);
	}
/**
 * 官解 思路类似，效率更高
 * public class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] G = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i)
            G[i] = new ArrayList<>();
        for (int[] e : edges) {
            G[e[0]].add(e[1]);
            G[e[1]].add(e[0]);
        }
        boolean[] seen = new boolean[n + 1];
        return dfs(G, seen, 1, t, target);
    }

    private double dfs(List<Integer>[] G, boolean[] seen, int i, int t, int target) {
        int nxt = i == 1 ? G[i].size() : G[i].size() - 1;//nxt，可访问点数（去掉父点）
        if (t == 0 || nxt == 0) {
            return i == target ? 1.0 : 0.0;
        }
        seen[i] = true;
        double ans = 0.0;
        for (int j : G[i]) {
            if (!seen[j]) {
                ans += dfs(G, seen, j, t - 1, target);
            }
        }
        return ans / nxt;
    }
}
 */
}