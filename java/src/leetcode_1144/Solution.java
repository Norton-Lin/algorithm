package leetcode_1144;

class Solution {
	//分别统计奇偶位的最少操作次数
    public int movesToMakeZigzag(int[] nums) {
        int ans1 = 0,ans2 = 0;
        if(nums.length == 1)
            return 0;
        for(int i = 0;i<nums.length;i+=2)
        {
            if(i == 0)
            {
                if(nums[i]>=nums[i+1])
                    ans1 = nums[i] - nums[i+1] +1;
            }
            else if(i == nums.length -1)
            {
                if(nums[i-1]<=nums[i])
                    ans1 += nums[i] - nums[i-1] +1;
            }
            else
            {
                if(nums[i]>=Math.min(nums[i+1],nums[i-1]))
                    ans1+=nums[i]-Math.min(nums[i+1],nums[i-1])+1;
            }
        }
        for(int i = 1;i<nums.length;i+=2)
        {
            if(i == nums.length -1)
            {
                if(nums[i-1]<=nums[i])
                    ans2 += nums[i] - nums[i-1] +1;
            }
            else
            {
                if(nums[i]>=Math.min(nums[i+1],nums[i-1]))
                    ans2+=nums[i]-Math.min(nums[i+1],nums[i-1])+1;
            }
        }
        return Math.min(ans1,ans2);
    }
}