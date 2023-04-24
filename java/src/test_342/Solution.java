package test_342;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;


class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
    	return (arrivalTime+delayedTime)%24;
    }
    public int sumOfMultiples(int n) {
    	int ans = 0;
    	for(int i = 3;i<=n;++i)
    		if(i%3==0||i%5==0||i%7==0)
    			ans+=i;
    	return ans;
    }
    //k长度的子数组，求美丽值
    //美丽值：子数组中第x小的数，若该数小于0，美丽值为此数，否则为0
    //暴力 klongk*(n-k)
    //dp 第i个子数组，第x小值为
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
    	int[] ans = new int[nums.length-k+1];
    	PriorityQueue<Integer> queue = new PriorityQueue<>();
    	TreeMap<Integer, Integer> map = new TreeMap<>();
    	for(int i=0;i<k-1;++i)
    	{
			queue.add(nums[i]);
    	}
    	for(int i = 0;i<ans.length;++i)//queue内全部合法
    	{
    		queue.add(nums[i+k-1]);
    		int[] cur = new int[x];
    		for(int j = 0;j<x;++j)
    			cur[j] = queue.poll();
    		ans[i] = cur[x]<0?cur[0]:0;
    		boolean judge = true;
    		for(int j:cur)
    		{
    			if(j==nums[i]&&judge)
    			{
    				judge = false;
    				continue;
    			}
    			queue.add(j);
    		}
    	}
    	return ans;
    }
    public static void main(String args[]) {
		Solution solution = new Solution();
		int[] ans = solution.getSubarrayBeauty(new int[] {-36,-42,-2,31,-16,-27},3, 1);
				
	}
}
