/*
 * @lc app=leetcode.cn id=1962 lang=java
 *
 * [1962] 移除石子使总数最小
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        long ans = 0;
        int cur = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int i : piles){
            queue.offer(i);
            ans += i;
        }
            
        while(k>0){
            cur = queue.poll();
            ans -= cur/2;
            queue.add(cur - cur/2);
            --k;
        }
        return (int)ans;
    }
}
// @lc code=end

