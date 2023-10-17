package leetcode_137;
/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int one = 0,two = 0;
        for(int i = 0;i<nums.length;++i)
        {
            one = one^nums[i]&(~two);
            two = two^nums[i]&(~one);
        }
        return one;
    }
}
// @lc code=end

