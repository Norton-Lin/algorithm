/*
 * @lc app=leetcode.cn id=2760 lang=java
 *
 * [2760] 最长奇偶子数组
 */
package leetcode_2760;
// @lc code=start
class Solution {
    // dp
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        int dp[] = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1]<=threshold?1:0;
        if(nums[nums.length-1]%2==0)
            ans = dp[nums.length-1];
        for(int i = nums.length-2;i>=0;--i){
            if(nums[i]>threshold)
                dp[i] = 0;
            else {
                if(nums[i]%2!=nums[i+1]%2)
                    dp[i] = dp[i+1]+1;
                else 
                    dp[i] = 1;
            }
            if(nums[i]%2==0)
                ans = Math.max(dp[i],ans);
        }
        return ans;
    }
    /**
    public static void main(String args[]){
        Solution solution = new Solution();
        int ans = solution.longestAlternatingSubarray(new int[]{3,2,5,4}, 5);
    }*/
}
// @lc code=end
