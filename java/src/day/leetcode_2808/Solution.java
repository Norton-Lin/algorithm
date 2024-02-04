/*
 * @lc app=leetcode.cn id=2808 lang=java
 *
 * [2808] 使循环数组所有元素相等的最少秒数
 */
package day.leetcode_2808;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    // 对每一个下标i，进行操作
    // 1 不变
    // 2 变成 nums[(i-1+n)%n] 前一个数
    // 3 变成 nums[(i+1)%n] 后一个数
    // 计算所有可能的x所需要的秒数
    public int minimumSeconds(List<Integer> nums) {
        int ans = nums.size() / 2;
        int cur = 0;// 每个数都不同的情况
        Map<Integer, List<Integer>> lists = new HashMap<>();
        for (int i = 0; i < nums.size(); ++i) {
            List<Integer> list = lists.getOrDefault(nums.get(i), new ArrayList<>());
            list.add(i);
            lists.put(nums.get(i), list);
        }
        for (List<Integer> list : lists.values()) {
            cur = 0;
            if (list.size() == 1)//该数只存在一次
                cur = nums.size() / 2;
            else {
                for (int i = 0; i < list.size() - 1; ++i) {
                    cur = Math.max((list.get(i + 1) - list.get(i)) / 2, cur);
                }
                //尾部处理
                cur = Math.max(cur, (nums.size() - list.get(list.size() - 1) + list.get(0)) / 2);
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
// @lc code=end
