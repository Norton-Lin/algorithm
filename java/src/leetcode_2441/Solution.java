package leetcode_2441;

import java.util.HashSet;


class Solution {
	//遍历
    public int findMaxK(int[] nums) {
    	int ans = -1;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
        {
            if(i<0)
                set.add(i);
        }
        	
        for(int i: nums)
        {
        	if(i>0&&set.contains(-i))
        		ans = Math.max(ans, i);
        }
        return ans;
    }
}
