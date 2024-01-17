package hot100.leetcode_1;
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    //哈希存储
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;++i){
            //检查是否存在对应数据
            if(map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]), i};
            map.put(nums[i],i);
        }
        return new int[]{};
    }
    //暴力双循环
    /**
    public int[] twoSum(int[] nums, int target){
        for(int i = 0;i<nums.length;++i){
            for(int j = i+1;j<nums.length;++j){
                if(nums[i]+nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return new int[]{};
    } */
}
// @lc code=end

