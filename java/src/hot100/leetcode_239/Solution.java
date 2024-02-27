package hot100.leetcode_239;
/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    // 维护最大值
    // 哈希表维护 滑动窗口 优先队列记录最大值
    /**
     * public int[] maxSlidingWindow(int[] nums, int k) {
     * Map<Integer, Integer> map = new HashMap<>();
     * PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
     * int[] ans = new int[nums.length - k + 1];
     * for(int i = 0;i<k;++i){
     * map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
     * queue.add(nums[i]);
     * }
     * ans[0] = queue.peek();
     * for(int i = k;i<nums.length;++i){
     * queue.add(nums[i]);
     * map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
     * map.put(nums[i-k],map.get(nums[i-k])-1);
     * if(map.get(nums[i-k]) == 0)
     * map.remove(nums[i-k]);
     * while(!map.containsKey(queue.peek()))
     * queue.poll();
     * ans[i-k+1] = queue.peek();
     * }
     * return ans;
     * }
     */
    // 优化
    // 时间上，存下标用于维护滑动窗口
    // 队列负责维护最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
        }
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; ++i) {
            while (!deque.isEmpty()&& nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            while (deque.peekFirst() <= i-k)
                deque.pollFirst();
            ans[i-k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
// @lc code=end
