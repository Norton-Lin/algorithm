package hot100.leetcode_283;
/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    //非零数字前移，尾部位置赋零
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0;i<nums.length;++i){
            if(nums[i] == 0)
                ++count;
            else
                nums[i-count] = nums[i];
        }
        for(int i = nums.length;count >0;--count)
            nums[i-count] = 0; 
    }
}
// @lc code=end

