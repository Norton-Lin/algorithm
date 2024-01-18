package hot100.leetcode_11;
/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    //双指针，头尾向中间靠拢
    //每次都找更高的
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = Math.min(height[left],height[right])*(right - left);
        int cur = 0;
        while(left<right){
            cur = Math.min(height[left],height[right])*(right - left);
            if(height[left]<height[right])
                ++left;
            else
                --right;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
// @lc code=end

