/*
 * @lc app=leetcode.cn id=2859 lang=java
 *
 * [2859] 计算 K 置位下标对应元素的和
 */

import java.util.List;
// @lc code=start
class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        int count = 0;
        for(int i = 0;i<nums.size();++i){
            int cur = i;
            count = 0;
            while(cur>0&&count<=k){
                if((cur&1)==1)
                    ++count;
                cur>>=1;
            }
            if(count==k)
                ans += nums.get(i);
        }
        return ans;
    }
}
// @lc code=end

