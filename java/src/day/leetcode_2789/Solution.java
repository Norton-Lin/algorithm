package day.leetcode_2789;
/*
 * @lc app=leetcode.cn id=2789 lang=java
 *
 * [2789] 合并后数组中的最大元素
 */

// @lc code=start
class Solution {
    //不断增大后位元素
    //最大元素将会是第一个
    //一次遍历 dp()
    public long maxArrayValue(int[] nums) {
        long cur = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;--i){
            if(cur >= nums[i])
                cur += nums[i];
            else
                cur = nums[i];
        }
        return cur;
    }
}
// @lc code=end

