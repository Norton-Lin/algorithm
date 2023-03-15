package leetcode_1615;

import java.util.ArrayList;


class Solution {
	//找两个城市，其路径数最多，每条路只算一次
	//做一个矩阵？空间占用过高，算了，先这么写吧 时间O(n^2) 空间 O(n^2)
	//还tm真行
	/**
    public int maximalNetworkRank(int n, int[][] roads) {
    	int[][] count = new int[n][n];//以某城市为起点的
    	int[] sum = new int[n];
    	for(int i = 0;i<roads.length;++i)
    	{
    		count[roads[i][0]][roads[i][1]]++;
    		count[roads[i][1]][roads[i][0]]++;
    		sum[roads[i][0]]++;
    		sum[roads[i][1]]++;
    	}
    	int ans = 0;
    	for(int i = 0;i<n;++i)
    	{
    		for(int j = i+1;j<n;++j)
    		{
    			ans = Math.max(ans, sum[i]+sum[j] - count[i][j]);
    		}
    	}
    	return ans;
    }*/
	//优化一下，贪心
	public int maximalNetworkRank(int n, int[][] roads) {
		boolean[][] count = new boolean[n][n];//以某城市为起点的
    	int[] sum = new int[n];
    	int first = -1,second = -2;
    	ArrayList<Integer> firstArrayList = new ArrayList<Integer>();
    	ArrayList<Integer> secondArrayList = new ArrayList<Integer>(); 
    	for(int i = 0;i<roads.length;++i)
    	{
    		count[roads[i][0]][roads[i][1]] = true;;
    		count[roads[i][1]][roads[i][0]] = true;
    		sum[roads[i][0]]++;
    		sum[roads[i][1]]++;
    	}
    	for(int i = 0;i<n;++i)
    	{
    		if(sum[i]>first)
    		{
    			second = first;
    			secondArrayList = new ArrayList(firstArrayList);
    			first = sum[i];
    			firstArrayList.clear();
    			firstArrayList.add(i);
    		}
    		else if(sum[i] == first)
    		{
    			firstArrayList.add(i);
    		}
    		else if(sum[i]>second)
    		{
    			second = sum[i];
    			secondArrayList.clear();
    			secondArrayList.add(i);
    		}
    		else if(sum[i] == second)
    			secondArrayList.add(i);
    	}
    	if(firstArrayList.size()>1)
    	{
             if (firstArrayList.size() * (firstArrayList.size() - 1) / 2 > roads.length) {
                return first * 2;
            }
    		for(int i: firstArrayList)
    		{
    			for(int j: firstArrayList)
    				if(i!=j&&!count[i][j])
                        return 2*first;
    		}
    		return 2*first -1 ;
    	}
    	else {
            int i = firstArrayList.get(0);
    		for(int j: secondArrayList)
    			if(!count[i][j])
                    return first+second;
    		return first+second -1;
    	}
	}
}