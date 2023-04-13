package leetcode_2404;

import java.util.HashMap;

class Solution {
    public int mostFrequentEven(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int ans = -1;
    	int num = 0;
    	for(int i : nums)
    	{
    		if(i%2==0)
    		{
                int cur = map.containsKey(i)?map.get(i)+1:1;
				map.put(i, cur);
                if(cur>num||(cur==num&&i<ans))
    		    {
    			    ans = i;
    			    num = cur;
    		    }	
    		}
    	}
    	return ans;
    }
}
