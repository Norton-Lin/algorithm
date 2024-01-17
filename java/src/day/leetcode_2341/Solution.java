package day.leetcode_2341;

import java.util.Arrays;

class Solution {
    public int[] numberOfPairs(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;)
        {
            if(nums[i]==nums[i+1])
            {
                ++ans;
                i+=2;
            }
            else
                ++i;
        }
        return new int[]{ans,nums.length-2*ans};
    }
}