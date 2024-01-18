package hot100.leetcode_42;
/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int right[] = new int[height.length];//记录右侧最高峰
        int left[] = new int[height.length];//记录左侧最高峰
        //左右端点显然不能装水
        for(int i = 1;i<left.length;++i)
            left[i] = Math.max(left[i-1],height[i-1]);
        for(int i = right.length-2;i>=0;--i)
            right[i] = Math.max(right[i+1],height[i+1]);
        for(int i = 0;i<height.length;++i){
            int num = Math.min(left[i], right[i])-height[i];
            if(num>0)
                ans += num;
        }
        return ans;
    }
}
// @lc code=end

