package day.leetcode_2562;
/*
 * @lc app=leetcode.cn id=2562 lang=java
 *
 * [2562] 找出数组的串联值
 */

// @lc code=start
class Solution {
    //串联最后两个数字，然后从数组中移除这个两个数字
    //重复上述过程然后累计串联值
    //因为此处nums[i]>0,因此无需考虑nums[i] == 0 的情况
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int i = 0,j = nums.length-1;
        long cur;
        int base;
        while(i<=j)
        {
            base = 1;
            if(i<j)
            {
                cur = nums[j];
                while(cur>0)//不用考虑cur==0，但是base==10的情况
                {
                    cur/=10;
                    base*=10;
                }
                ans+=nums[j];
            }
            ans+= nums[i]*base;
            ++i;
            --j;
        }
        return ans;
    }
}
// @lc code=end

