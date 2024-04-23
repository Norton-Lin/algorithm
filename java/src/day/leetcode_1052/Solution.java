package day.leetcode_1052;
/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start
class Solution {
    //customer[i] 分钟内进入并离开
    //grumpy[i]第i分钟生气
    //minutes 连续时间内不生气
    //让连续minutes时间内本应生气但不生气最大化即可
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int num = 0;//原本就不生气的
        int ans = 0;//可让不满意变满意的最大人数
        int cur = 0;
        for(int i = 0;i<minutes;++i){
            if(grumpy[i] == 0)
                num+=customers[i];
            else
                cur = ans+=customers[i];
        }
        for(int i = minutes;i<customers.length;++i){
            if(grumpy[i-minutes] == 1)
                cur -= customers[i-minutes];
            if(grumpy[i] == 0){
                num+=customers[i];
            }
            else{
                cur += customers[i];
                ans = Math.max(ans,cur);
            }
        }
        return num+ans;
    }
}
// @lc code=end

