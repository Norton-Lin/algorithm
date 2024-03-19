/*
 * @lc app=leetcode.cn id=1793 lang=java
 *
 * [1793] 好子数组的最大分数
 */
package day.leetcode_1793;
// @lc code=start
class Solution {
    //求序列最小值乘序列长度，以k为界
    //以k为界，求i-k的min ，k-j的min（单调栈）
    //然后从k出发，向两端延伸
    public int maximumScore(int[] nums, int k) {
        int ans = 0;
        int left = k,right = k;//双指针
        int[] value = new int[nums.length];//记录区间最小值
        int cur = value[k] = nums[k];
        for(int i = k-1;i>=0;--i){
            if(cur > nums[i])
                cur = nums[i];
            value[i] = cur;
        }
        cur = nums[k];
        for(int i = k+1;i<nums.length;++i){
            if(cur > nums[i])
                cur = nums[i];
            value[i] = cur;
        }
        while(left >= 0||right<nums.length){
            while(left >0&&value[left] == value[left - 1])
                --left;
            while(right<nums.length-1&&value[right] == value[right + 1])
                ++right;
            ans = Math.max(Math.min(value[left],value[right]) * (right - left + 1),ans);
            if(left >0 && value[left - 1]>value[right]){
                --left;
            }else if(right<nums.length-1&&value[right+1]>value[left]){
                ++right;
            }else{
                if(left > 0 && right<nums.length-1){
                    if(value[left - 1]>value[right + 1]){
                        --left;
                    }else{
                        ++right;
                    }
                }else if(left > 0)
                    --left;
                else if(right< nums.length -1)
                    ++right;
                else 
                    break;
            }
        }
        return ans;
        
    }
}
// @lc code=end

