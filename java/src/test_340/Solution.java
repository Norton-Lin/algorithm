package test_340;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public int diagonalPrime(int[][] nums) {
		int ans = 0;
		int[] parm = new int[2*nums.length];
		int count = 0;
		for(int i = 0;i<nums.length;++i)
		{
			parm[count++] = nums[i][i];
			parm[count++] = nums[i][nums[i].length-1-i];
		}
		Arrays.sort(parm);
        return phi(parm);
    }
	public static int phi(int[] parm) {
		int len = parm.length;
		int n = parm[len-1]+1;
		boolean[] is_prime = new boolean[n];
		int[] prime= new int[n];
		is_prime[0] = true;
		is_prime[1] = true;
		int count = 0;
		int ans = 0;
		for(int i = 2;i<n;++i)
		{
			if(is_prime[i] == false)
				prime[count++] = i;
			for(int j = 0;j<count&&i*prime[j]<n;++j)
			{
				is_prime[i*prime[j]] = true;
				if(i%prime[j] == 0)
					break;
			}
		}
		int i = 0;
		for(i = len-1;i>=0;--i)
			if(!is_prime[parm[i]])
				return parm[i];
		return 0;
	}
	//对于满足 nums[j] == nums[i] 且 j != i 的所有 j ，
	//arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。
	public long[] distance(int[] nums) {
		HashMap<Integer, ArrayList<Long>> map = new HashMap<>();
		HashMap<Integer, Integer> index = new HashMap<>();
		long[] arr = new long[nums.length];
		Arrays.fill(arr, 0);
		int count = 0;
		for(int i:nums)//O（n)
		{
			if(!map.containsKey(i))
			{
				ArrayList<Long> cur = new ArrayList<Long>();
				cur.add((long)count);//前缀和
				map.put(i, cur);
			}
			else {
				ArrayList<Long> cur = map.get(i);
				cur.add(count+cur.get(cur.size()-1));
				map.put(i, cur);
			}
			++count;
		}
		for(int i = 0;i<arr.length;++i)
		{
			ArrayList<Long> cur = map.get(nums[i]);
			if(index.containsKey(nums[i]))
				index.put(nums[i], index.get(nums[i])+1);
			else
				index.put(nums[i], 0);
			count = index.get(nums[i]);
			if(count == 0||count == cur.size()-1)
				arr[i] = Math.abs(cur.get(cur.size()-1) - count*cur.size());
			else {
				arr[i] = Math.abs(cur.get(cur.size()-1)-cur.get(count)-(i*(cur.size()-1-count)))
						+Math.abs(i*count - cur.get(count-1));
			}
		}
		return arr;
    }
	public static void main(String args[])
	{
		Solution solution = new Solution();
		
		long[] arr = solution.distance(new int[] {2,0,2,2,6,5,2});
		for(int i = 0;i<arr.length;++i)
			System.out.println(arr[i]);
	}
}
