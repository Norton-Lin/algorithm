/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start

//package leetcode_307;

class NumArray {
    private int[] nums;
    private int[] sum;
    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.sum = new int[nums.length+1];
        for(int i = 0;i<nums.length;++i){
            this.nums[i] = nums[i];
            this.sum[i+1] = nums[i] + sum[i]; 
        }
    }
    
    public void update(int index, int val) {
        for(int i = sum.length-1;i>index;--i){
            sum[i] = sum[i] - nums[index] + val;
        }
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return sum[right+1] - sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

