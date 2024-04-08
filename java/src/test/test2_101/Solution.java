package test.test2_101;

import java.nio.file.attribute.AclEntry;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
    	HashSet<Integer> set = new HashSet<>();
    	int min1 = 10,min2 = 10;
    	int cur = 10;
    	for(int num:nums1)
    	{
    		if(num<min1)
    			min1 = num;
    		set.add(num);
    	}
    	for(int num:nums2)
    	{
    		if(num<min2)
    			min2 = num;
    		if(set.contains(num)&&cur>num)
    			cur = num;
    	}
    	if(cur<10)
    		return cur;
    	return Math.min(min2, min1)*10+Math.max(min2, min1);
    	
    }
    //价值 为 chars 对应val,否则为 c-'a'+1
    int[] all_vals = new int[26];
    public int maximumCostSubstring(String s, String chars, int[] vals) {
    	for(int i = 0;i<26;++i)
    		all_vals[i] = i+1;
    	int index = 0;
    	for(char c:chars.toCharArray())
    		all_vals[c-'a'] = vals[index++];
    	int ans = 0;//最大开销
    	int cur = 0;//当前开销
    	for(char c:s.toCharArray())
    	{
    		
    		if(cur+all_vals[c-'a']<all_vals[c-'a'])
    			cur = all_vals[c-'a'];
    		else
    			cur+=all_vals[c-'a'];
    		ans = Math.max(ans, cur);
    	}
    	return ans;
    }
    //长度为k的子数组值都相同
    //让所有合值都逼近一个整数平均值
    public long makeSubKSumEqual(int[] arr, int k) {
    	int[] nums = new int[arr.length*2];
    	long[] dp = new long[arr.length];
    	long sum = 0;
    	long ave = 0;
    	long ans = 0;
    	for(int i = 0;i<arr.length;++i)
    	{
    		nums[i] = arr[i];
    		nums[i+arr.length] = arr[i];
    		sum+=arr[i];
    	}
    	for(int i = 0;i<k;++i)
    		dp[0]+=nums[i];
    	for(int i = 1;i<dp.length;++i)
    		dp[i] = dp[i-1] - nums[i-1]+nums[i+k-1];
    	ave = sum/arr.length;
    	if(sum - ave*arr.length > (ave+1)*arr.length - sum)
    		++ave;
    	ave*=k;
    	int count = 0,i = 0;
    	System.out.print(ave);
    	while(count<arr.length)
    	{
    		i %=(dp.length);
    		if(dp[i] == ave)
    			++count;
    		else {
    			long tmp = dp[i] - ave;
    			for(int j = 0;j<k;++j)
    				dp[(i-j+dp.length)%dp.length]-=tmp;
    			++ans;
    			count = 0;
    		}
    		++i;
    	}
    	return ans;
    	
    }
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	Scanner in = new Scanner(System.in);
    	int[] parm = new int[4];
    	for(int i = 0;i<parm.length;++i)
    		parm[i] = in.nextInt();
		long ans = solution.makeSubKSumEqual(parm, 2);
		System.out.print(ans);
	}
}