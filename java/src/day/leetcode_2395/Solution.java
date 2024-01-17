package day.leetcode_2395;

import java.util.HashSet;

class Solution {
	//1 相加搜索 O(n^2)
	//2 相加后排序 O(nlogn)
	//3 哈希 O(n)
	/**
    public boolean findSubarrays(int[] nums) {
        for(int i = 0;i<nums.length-1;++i)
            nums[i] = nums[i] + nums[i+1];
        for(int i = 0;i<nums.length-1;++i)
        {
            for(int j = i+1;j<nums.length-1;++j)
                if(nums[i] == nums[j])
                    return true;
        }
        return false;
    }*/
	public boolean findSubarrays(int[] nums) {
		HashSet<Integer> set  = new HashSet<>(null);
		int num = 0;
		for(int i = 1;i<nums.length;++i)
		{
			num = nums[i]+ nums[i-1];
			if(set.contains(num))
				return true;
			else 
				set.add(num);
		}
		return false;
	}

}