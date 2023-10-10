package leetcode_2731;
/*
 * @lc app=leetcode.cn id=2731 lang=java
 *
 * [2731] 移动机器人
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    //s代表移动的方向
    //nums代表机器人的初始位置
    //机器人碰撞后，将向反方向运动
    //相邻两个机器人同向移动不碰撞，距离不变
    // 1,2间的距离要算n-1次，2,3间的距离要算n-1+n-1
    // 3,4间的距离要算3*n-2次
    // n-1 n间的距离算n-1次
    // 用long!
    public int sumDistance(int[] nums, String s, int d) {
        long ans = 0;
        long pos[] = new long[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(s.charAt(i)=='L'){
                pos[i] = (long)nums[i]-d;
            }else{
                pos[i] = (long)nums[i]+d;
            }
        }
        Arrays.sort(pos);
        for(int i = 1;i<nums.length;++i){
            ans += 1L*(pos[i] - pos[i-1])*(i)%1000000007*(nums.length-i)%1000000007;
            ans%=1000000007;
        }
        return (int)ans;
    }
}
// @lc code=end

