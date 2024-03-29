package day.leetcode_2908;
/*
 * @lc app=leetcode.cn id=2908 lang=java
 *
 * [2908] 元素和最小的山形三元组 I
 */

// @lc code=start
class Solution {
    //i<j<k
    //nums[i]<nums[j] nums[k]<nums[j]
    //单调栈，找某个数左右两边的最小值
    public int minimumSum(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int[] min = new int[nums.length];
        int cur  = nums[nums.length-1];
        min[nums.length-1] = 51;
        for(int i = nums.length-2;i>=0;--i)
        {
            cur = nums[i+1];
            if(cur<min[i+1])
                min[i] = cur;
            else
                min[i] = min[i+1];
        }
        cur = nums[0];
        for(int i = 1;i<nums.length-1;++i){
            if(nums[i]<=cur||nums[i]<=min[i]){
                if(nums[i]<cur)
                    cur = nums[i];
                continue;
            }
            ans = Math.min(ans, nums[i]+cur+min[i]);
            
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.minimumSum(new int[]{8,6,1,5,3});
    }
}
// @lc code=end

