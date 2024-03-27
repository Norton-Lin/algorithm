package day.leetcode_2580;
/*
 * @lc app=leetcode.cn id=2580 lang=java
 *
 * [2580] 统计将重叠区间合并成组的方案数
 */
import java.util.Arrays;
import java.util.Comparator;
// @lc code=start
class Solution {
    //元素划分为n组，然后2^n(快速幂)
    //区间合并
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int a[], int b[]){
                if(a[0]!=b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        int record = 1;
        //int left = ranges[0][0];
        int right = ranges[0][1];
        for(int i = 1;i<ranges.length;++i){
            int cur[] = ranges[i];     
            if(cur[0]>right)
                ++record;
            right = cur[1]>right?cur[1]:right;
        }
        return pow(2, record, 1000000007);
    }
    //快速幂
    public int pow(long base, long power, long mod){
        long ans = 1;
        while(power>0){
            if((power&1)==1)
                ans = ans*base%mod;
            power >>=1;
            base = base*base%mod;
        }
        return (int)ans;
    }
}
// @lc code=end

