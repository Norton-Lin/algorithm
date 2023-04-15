package leetcode_1042;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    //相邻的点着色不同，四种花可选，一个点最多哦与三个相邻
    //图着色问题
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        HashMap<Integer,List<Integer>> map = new HashMap<>();//改成List<Integer>[]更好
        for(int i = 0;i<paths.length;++i)
        {
        	int dot1 = paths[i][0];
        	int dot2 = paths[i][1];
        	List<Integer> cur1 = new ArrayList<>();
        	List<Integer> cur2 = new ArrayList<>();
        	if(map.containsKey(dot1))
        	{
        		cur1 = map.get(dot1);
        		
        	}
        	cur1.add(dot2);
    		map.put(dot1, cur1);
    		if(map.containsKey(dot2))
        	{
        		cur2 = map.get(dot2);
        		
        	}
        	cur2.add(dot1);
    		map.put(dot2, cur2);
        }
        for(int i = 1;i<=n;++i)
        {
        	if(!map.containsKey(i))
        	{
        		ans[i-1] = 1;
        		continue;
        	}
        	List<Integer> cur = map.get(i);
        	boolean[] judge = new boolean[5];
        	for(int j:cur)
        		judge[ans[j-1]] = true;
        	for(int j = 1;j<5;++j)
        	{
        		if(!judge[j])
        		{
        			ans[i-1] = j;
        			break;
        		}
        	}
        }
        return ans;
    }
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int[] ans = solution.gardenNoAdj(4, new int[][] {{1,2},{2,3},{3,1}});
    	for(int i: ans)
    		System.out.println(i);
		
	}
}