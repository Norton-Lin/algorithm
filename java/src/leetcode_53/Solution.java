/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */
package leetcode_53;
// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cur = 0;
        for(int i:nums){
            cur+=i;
            if(cur<i)
                cur = i;
            ans = Math.max(cur,ans);
        }
        return ans;
    }
}
// @lc code=end

