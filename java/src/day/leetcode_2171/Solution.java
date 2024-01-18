package day.leetcode_2171;
/*
 * @lc app=leetcode.cn id=2171 lang=java
 *
 * [2171] 拿出最少数目的魔法豆
 */

import java.util.Arrays;
// @lc code=start
class Solution {
    //非空袋子中的豆子数量相同
    //要么把袋子拿空，要么拿少
    //选取基准，大于基准的拿到基准，小于基准的拿空

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long pre = 0,cur = 0;
        long sum = 0;
        long ans = Long.MAX_VALUE;
        for(int i = 0;i<beans.length;++i){
            sum+=beans[i];
        }
        for(int i = 0;i<beans.length;++i){
            //pre指清零豆子，其余指减到基准的豆子
            sum -= beans[i];
            cur = pre + sum - (long)beans[i]*(beans.length - i - 1);
            ans = Math.min(ans,cur);
            pre += beans[i];
        }
        return ans;
    }
}
// @lc code=end

