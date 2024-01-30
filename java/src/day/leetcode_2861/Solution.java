package day.leetcode_2861;
/*
 * @lc app=leetcode.cn id=2861 lang=java
 *
 * [2861] 最大合金数
 */

import java.util.List;
// @lc code=start
class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int left = 1, right = budget / cost.get(0) + stock.get(0), ans = 0;
        //二分查找ans
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean valid = false;
            //遍历机器
            for (int i = 0; i < k; ++i) {
                long spend = 0;
                //遍历金属
                for (int j = 0; j < n; ++j) {
                    spend += Math.max((long) composition.get(i).get(j) * mid - stock.get(j), 0) * cost.get(j);
                }
                //本机器符合当前答案条件
                if (spend <= budget) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

