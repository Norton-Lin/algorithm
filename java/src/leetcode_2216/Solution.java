/*
 * @lc app=leetcode.cn id=2216 lang=java
 *
 * [2216] 美化数组的最少删除数
 */

// @lc code=start
class Solution {
    public int minDeletion(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                i++;
            else {
                res++;
            }
        }
        if ((nums.length - res) % 2 == 0)
            return res;
        else
            return res + 1;
    }
}
// @lc code=end
