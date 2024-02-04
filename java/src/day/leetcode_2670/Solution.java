package day.leetcode_2670;

/*
 * @lc app=leetcode.cn id=2670 lang=java
 *
 * [2670] 找出不同元素数目差数组
 */
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    // 哈希
    /**
     * public int[] distinctDifferenceArray(int[] nums) {
     * int diff[] = new int[nums.length];
     * Map<Integer, Integer> pre= new HashMap<>();
     * Map<Integer, Integer> back= new HashMap<>();
     * for(int num: nums)
     * back.put(num,back.getOrDefault(num, 0)+1);
     * for(int i = 0;i<nums.length;++i){
     * pre.put(nums[i], pre.getOrDefault(nums[i], 0)+1);
     * int cur = back.get(nums[i]);
     * if(cur == 1)
     * back.remove(nums[i]);
     * else
     * back.put(nums[i], cur -1);
     * diff[i] = pre.size() - back.size();
     * }
     * return diff;
     * }
     */
    public int[] distinctDifferenceArray(int[] nums) {
        int diff[] = new int[nums.length];
        int pre[] = new int[51];
        int back[] = new int[51];
        int count1 = 0;
        int count2 = 0;
        for (int num : nums){
            if(back[num]==0)
                ++count2;
            ++back[num];
        }
        for (int i = 0; i < nums.length; ++i) {
            if(pre[nums[i]]==0)
                ++count1;
            ++pre[nums[i]];
            --back[nums[i]];
            if(back[nums[i]] == 0)
                --count2;
            diff[i] = count1 - count2;
        }
        return diff;
    }
}
// @lc code=end
