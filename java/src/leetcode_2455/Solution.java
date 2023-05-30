package leetcode_2455;

class Solution {
    public int averageValue(int[] nums) {
    	int ans = 0;
        int count = 0;
    	for(int i:nums)
    	{
    		if(i%6==0)
            {
    			ans+=i;
                ++count;
            }
    	}
        if(count == 0)
            count = 1;
    	return ans/count;
    }
}