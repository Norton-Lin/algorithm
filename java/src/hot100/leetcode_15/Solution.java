package hot100.leetcode_15;
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// @lc code=start


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(){};
        Arrays.sort(nums);
        int sum = 0;
        int record = -100001;
        for(int i = 0;i<nums.length;++i){
            if(i>0&&nums[i] == nums[i-1])//第一个数不变，跳过
                continue;
            //处理后两个数
            record = -100001;
            for(int j = i+1,k = nums.length-1;j<k;){
                if(record == nums[j]){
                    ++j;
                    continue;
                }
                sum = nums[i]+nums[j]+nums[k];
                if(sum<0)
                    ++j;
                else if(sum == 0){
                    record = nums[j];
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    ++j;
                    --k;
                }
                else
                    --k;
            }
        }
        return ans;
    }
}
// @lc code=end

