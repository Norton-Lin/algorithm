/*
 * @lc app=leetcode.cn id=2656 lang=java
 *
 * [2656] K 个元素的最大和
 */

// @lc code=start
class Solution {
    //O(n) 找最大值就行
    public int maximizeSum(int[] nums, int k) {
        int ans = 0;
        int num = 0;
        for(int cur:nums)
            if(cur>num)
                num = cur;
        ans = (num + num+k-1)*k/2;
        return ans;
    }
}
// @lc code=end

