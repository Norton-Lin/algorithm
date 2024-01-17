/*
 * @lc app=leetcode.cn id=1671 lang=java
 *
 * [1671] 得到山形数组的最少删除次数
 */

package day.leetcode_1671;
// @lc code=start


class Solution {
    //山型数组，两侧单调递减
    //记录一侧严格大于该位置数组数的数量
    //前后看最长递增子序列
    public int minimumMountainRemovals(int[] nums) {
        int ans = 0;
        int cur = 1;
        int[] record1 = new int[nums.length];//以第i个数为结尾，最长子序列
        int[] record2 = new int[nums.length];
        for(int i = 0;i<nums.length;++i){
            cur = 1;
            int j = i - 1;
            while(j>=0){
                if(nums[i]>nums[j]){
                    cur = Math.max(record1[j]+1,cur);
                }
                --j;
            }
            record1[i] = cur;
        }
        for(int i = nums.length-1;i>=0;--i){
            cur = 1;
            int j = i + 1;
            while(j<nums.length){
                if(nums[i]>nums[j]){
                    cur = Math.max(record2[j]+1,cur);
                }
                ++j;
            }
            record2[i] = cur;
        }
        boolean judge = false;
        int end = nums.length-1;
        for(int i = nums.length-1;i>=0;--i){
            if(record2[i] != 1)
                judge = true;
            if(judge){
                end = i;
                break;
            }
        }
        judge = false;
        for(int i = 0;i<=end;++i){
            if(record1[i] != 1)
                judge = true;
            if(judge){
                ans = Math.max(ans,record1[i]+record2[i]-1);
            }
        }
        
        return nums.length-ans;
    }
}
// @lc code=end

