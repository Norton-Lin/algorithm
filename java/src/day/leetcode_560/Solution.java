package day.leetcode_560;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */
import java.util.HashMap;

// @lc code=start
public class Solution {
    // 前缀和+ 哈希优化
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];// 前缀和
            if (mp.containsKey(pre - k)) //存在符合的前缀
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}

// @lc code=end
