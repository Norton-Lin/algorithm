package day.leetcode_1465;
/*
 * @lc app=leetcode.cn id=1465 lang=java
 *
 * [1465] 切割后面积最大的蛋糕
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    //自左向右、自上向下 遍历，每次找右下方的第一个点
    //做一个蛋糕矩阵？ 太大了
    //纵向、横向矩阵都做一个排列，然后求右下
    public static int mod = 1000000000+7;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long ans = 0;
        long cur = 0;
        int[] rows = new int[horizontalCuts.length+2];
        int[] cols = new int[verticalCuts.length+2];
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        rows[0] = cols[0] = 0;
        rows[rows.length-1] = h;
        cols[cols.length-1] = w;
        for(int i = 0;i<horizontalCuts.length;++i)
            rows[i+1] = horizontalCuts[i];
        for(int i = 0;i<verticalCuts.length;++i)
            cols[i+1] = verticalCuts[i];
        for(int i = 1;i<rows.length;++i){
            for(int j = 1;j<cols.length;++j){
                cur = ((long)(rows[i] - rows[i-1])%mod)*((long)(cols[j]-cols[j-1])%mod);//溢出
                ans = Math.max(ans,cur);
            }
        }
        return (int)(ans%mod);
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int ans = s.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2});
        System.out.println(ans);
    }
}
// @lc code=end

