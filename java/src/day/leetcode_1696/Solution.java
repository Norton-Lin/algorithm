package day.leetcode_1696;

/*
 * @lc app=leetcode.cn id=1696 lang=java
 *
 * [1696] 跳跃游戏 VI
 */
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    // 一路往后跳，每次最多跳K步（i+1，min(n-1,i+k))
    // 求最大得分
    // 得分是正数，跳达，是负数，尽可能快速通过
    // 最后一步是达到n-1,即0到n-1
    // dp[i] 到第i位置时的最大得分
    // dp[i] = max(i-1...i-k) + nums[i]
    // 优先队列维护最大值
    public int maxResult(int[] nums, int k) {
        int ans = nums[0];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        queue.offer(new int[]{ans,0});
        int start = 0;
        for (int i = 1; i < nums.length; ++i) {
            start = i - k > 0 ? i - k : 0;
            while(queue.peek()[1]<start)
                queue.poll();
            int[] cur = queue.peek();
            ans = cur[0] + nums[i];
            queue.offer(new int[]{ans,i});
        }
        return ans;
    }
}
// @lc code=end
