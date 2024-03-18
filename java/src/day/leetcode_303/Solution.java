package day.leetcode_303;
/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i<sum.length;++i){
            sum[i] = sum[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0)
            return sum[right];
        return sum[right] - sum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

