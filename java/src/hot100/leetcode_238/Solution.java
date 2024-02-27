package hot100.leetcode_238;
/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    //前后缀积
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] back = new int[nums.length];
        pre[0] = 1;
        back[nums.length-1] = 1;
        for(int i = 1;i<nums.length;++i){
            pre[i] = nums[i-1]*pre[i-1];
        }
        for(int i = nums.length-2;i>=0;--i){
            back[i] = nums[i+1]*back[i+1];
            pre[i] = back[i] * pre[i];
        }
        return pre;
    }
    public static void main(String args[]){
        Solution s  = new Solution();
        s.productExceptSelf(new int[]{1,2,3,4});
    }
}
// @lc code=end

