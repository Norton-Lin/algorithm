package day.leetcode_2529;
/*
 * @lc app=leetcode.cn id=2529 lang=java
 *
 * [2529] 正整数和负整数的最大计数
 */

// @lc code=start
class Solution {
    public int maximumCount(int[] nums) {
        int num = 0;
        int zero = 0;
        while(num<nums.length&&nums[num]<0)
            ++num;
        while(num+zero<nums.length&&nums[num+zero]==0)
            ++zero;
        return Math.max(num,nums.length-num-zero);
    }
}
// @lc code=end

