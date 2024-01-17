package day.leetcode_1330;

class Solution {
	//端点交换,O(n2)超时
	/*
    public int maxValueAfterReverse(int[] nums) {
    	int ans = 0,cur = 0,base = 0;
    	for(int i = 1;i<nums.length;++i)
    	{
    		base+=Math.abs(nums[i-1]-nums[i]);
    	}
    	ans = base;
    	for(int i = 0;i<nums.length-1;++i)
    	{
    		for(int j = i+1;j<nums.length;++j)
    		{
    			if(i>0&&j<nums.length-1)
    			{
    				cur = base-Math.abs(nums[i]-nums[i-1])-Math.abs(nums[j+1]-nums[j])+
    						Math.abs(nums[j+1]-nums[i])+Math.abs(nums[j]-nums[i-1]);
   
    			}
    			else if(i>0&&j==nums.length-1)
    			{
    				cur = base-Math.abs(nums[i]-nums[i-1])+Math.abs(nums[j]-nums[i-1]);
    			}
    			else if(i==0&&j<nums.length-1)
    			{
    				cur = base-Math.abs(nums[j+1]-nums[j])+Math.abs(nums[j+1]-nums[i]);
    			}
    			ans = Math.max(ans,cur);
    		}
    	}
    	return ans;
    }*/
	//dp优化
	public int maxValueAfterReverse(int[] nums) {
        int value = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            value += Math.abs(nums[i] - nums[i + 1]);
        }
        int mx1 = 0;
        for (int i = 1; i < n - 1; i++) {
            mx1 = Math.max(mx1, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            mx1 = Math.max(mx1, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }
        int mx2 = Integer.MIN_VALUE, mn2 = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            mx2 = Math.max(mx2, Math.min(x, y));
            mn2 = Math.min(mn2, Math.max(x, y));
        }
        return value + Math.max(mx1, 2 * (mx2 - mn2));
    }
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int ans = solution.maxValueAfterReverse(new int[] {2,3,1,5,4});
		
	}
}
