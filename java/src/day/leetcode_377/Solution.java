package day.leetcode_377;
/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */
import java.util.Arrays;
// @lc code=start

class Solution {
    //dp
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.sort(nums);
        //nums[i]可能大于target
        for(int i = 0;i<nums.length&&nums[i]<=target;++i)
            dp[nums[i]] = 1;
        for(int i = 0;i<=target;++i){
            for(int j = 0;j<nums.length&&i>=nums[j];++j){
                dp[i] +=dp[i-nums[j]];
            }
            
        }
        return dp[target];

    }
}
// @lc code=end

