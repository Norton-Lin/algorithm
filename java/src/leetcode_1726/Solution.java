package leetcode_1726;
/*
 * @lc app=leetcode.cn id=1726 lang=java
 *
 * [1726] 同积元组
 */

import java.util.HashMap;

// @lc code=start
class Solution {
    //组合数*8，当两组数相同，将有8种组合
    //而组合数为 n!/(n-2)!*2!
    // 即 n*n-1*4
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        int cur = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //获取所有乘积的数量
        //因为nums元素互不相同，所以每个乘积的构成都不一样
        for(int i = 0;i<nums.length;++i){
            for(int j = i+1;j<nums.length;++j){
                cur = nums[i]*nums[j];
                map.put(cur,map.getOrDefault(cur, 0)+1);
            }
        }
        for(Integer i: map.keySet())
        {
            cur = map.get(i);
            ans+=cur*(cur-1)*4;
        }
        return ans;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int ans = s.tupleSameProduct(new int[]{2,3,4,6});
    }
}
// @lc code=end

