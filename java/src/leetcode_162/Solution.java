/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    //找到一个峰值索引，复杂度O(log n)
    //正常情况下，一次遍历 O(n)即可
    //类似二分查找
    //因为相邻数据不同，若为单调数组，则峰值在头尾
    //上下坡 nums[i-1]<nums[i]<nums[i+1]往i+1方向走
    //反之同理
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length-1;
        int mid = (right+left)/2;
        int ans = -1;
        while(left<=right){
            mid = (right+left)/2;
            if(compare(nums, mid-1, mid))//nums[i-1]>nums[i]
                right = mid-1;
            else{
                if(compare(nums, mid, mid+1))
                    break;
                left = mid + 1;
            }
        }
        return mid;
    }
    //false小于，true大于
    private boolean compare(int[] nums, int index1, int index2){
        if(index1<0)
            return false;
        if(index2==nums.length)
            return true;
        return nums[index1]>nums[index2];
    }
}
// @lc code=end

