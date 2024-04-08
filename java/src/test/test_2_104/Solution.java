package test.test_2_104;

import java.util.Arrays;

public class Solution {
	public int countSeniors(String[] details) {
		int ans = 0;
		for(String s:details)
		{
			if(s.charAt(11)-'0'>6)
			{
				++ans;
			}
			else if(s.charAt(11)-'0'==6&&(s.charAt(11)-'0'>0))
				++ans;
				
		}
		return ans;
    }
	//行row,列col
	//每次删除每行最大的数，取删除数的最大值
	public int matrixSum(int[][] nums) {
		int ans = 0;
		int cur = 0;
		for(int i = 0;i<nums.length;++i)
			Arrays.sort(nums[i]);
		for(int i = 0;i<nums[0].length;++i)//按列
		{
			cur = 0;
			for(int j = 0;j<nums.length;++j)//行
			{
				cur = Math.max(cur, nums[j][i]);
			}
			ans+=cur;
		}
		return ans;
    }
	//最多k次 *2操作，让nums的或值最大
	//统计位数，避免反复计算
	public long maximumOr(int[] nums, int k) {
		String[] bit = new String[nums.length];
		int len = 0;
		long ans = 0,cur = 0;
		for(int i = 0;i<nums.length;++i)
		{
			ans = ans|nums[i];
			bit[i] = new String();
			bit[i] = reverse(Integer.toBinaryString(nums[i]));
			len = Math.max(bit[i].length(), len);
		}
		int[] count = new int[len];
		for(int i = 0;i<nums.length;++i)
		{
			for(int j = 0;j<bit[i].length();++j)
			{
				if(bit[i].charAt(j)=='1')
					++count[j];
			}
		}
		long ret = 0;
		for(int i = 0;i<nums.length;++i)
		{
			cur=ans; 
			for(int j = 0;j<bit[i].length();++j)
			{
				if(bit[i].charAt(j)=='1'&&count[j]==1)
					cur = cur^(1<<j);
			}
			ret = Math.max(ret, cur|(long)((long)nums[i]<<k));
		}
		return ret;
		
    }
	String reverse(String s)
	{
		StringBuilder retBuilder = new StringBuilder(s);
		retBuilder.reverse();
		return retBuilder.toString();
	}
	static int mod = (int) (1e9 + 7);
	public int sumOfPower(int[] nums) {
		Arrays.sort(nums);
		int[][] arr1 = new int[nums.length][2];
		int[][] arr2 = new int[nums.length][2];
		int ans = 0;
		for(int i = 0;i<nums.length;++i)
		{
			arr1[i][0] = nums[i];
			arr1[i][1] = 1<<nums.length-i-1;
			arr2[i][0] = nums[i];
			arr2[i][1] = 1<<i;
		}
		for(int i = 0;i<nums.length;++i)
		{
			ans=(ans+(arr1[i][0]*arr1[i][1])%mod)%mod;
			ans=(ans+(arr2[i][0]*arr2[i][1])%mod)%mod;
		}
		return ans;
    }
	public static void main(String args[]) {
		Solution solution = new Solution();
		long ans = solution.maximumOr(new int[] {12,9}, 1);
		System.out.print(ans);
	}
}
