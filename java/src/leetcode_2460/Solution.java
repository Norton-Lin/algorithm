package leetcode_2460;

class Solution {
	/**
	 * 纯模拟+冒泡移位 O(n^2)
	 * @param nums
	 * @return
	 */
	/**
    public int[] applyOperations(int[] nums) {
    	int index = nums.length;
    	
    	for(int i = 1;i<nums.length;++i)
    	{
    		if(nums[i] == nums[i-1])
    		{
    			nums[i-1]*=2;
    			nums[i] = 0;
    		}
    	}
    	//不能直接换，冒泡
    	while(index>0)
    	{
    		for(int i = 0;i<index;++i)
        	{
        		if(nums[i]==0)
        		{
        			nums[i] = nums[i+1];
        			nums[i+1] = 0;
        		}
        	}
    		--index;
    	}
    	return nums;
    }*/
	/**
	 * O(n)
	 * @param nums
	 * @return
	 */
	public int[] applyOperations(int[] nums) {
		int[] ans = new int[nums.length];
		int j = 1;
		for(int i = 1;i<nums.length;++i)
    	{
    		if(nums[i] == nums[i-1])
    		{
    			nums[i-1]*=2;
    			nums[i] = 0;
    		}
    		if(nums[i-1]!=0)
    		{
    			ans[j-1] = nums[i-1];
    			++j;
    		}
    	}
		if(nums[nums.length-1]!=0)
			ans[j-1] = nums[nums.length-1];
		return ans;
	}
}
