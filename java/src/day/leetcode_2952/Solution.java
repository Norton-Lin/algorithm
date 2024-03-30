package day.leetcode_2952;
/*
 * @lc app=leetcode.cn id=2952 lang=java
 *
 * [2952] 需要添加的硬币的最小数量
 */

import java.util.Arrays;
// @lc code=start

class Solution {
    // 贪心
    public int minimumAddedCoins(int[] coins, int target) {
        int ans = 0;
        int cur = 1;
        int index = 0;
        int len = coins.length;
        while(cur<=target){
            if(index<len&&cur>=coins[index]){//
                ++index;
                cur+=coins[index];//范围内的数字都可以取得
            }else{
                cur*=2;//引入新的数
                ++ans;
            }
        }
        return ans;
    }
}
// @lc code=end
