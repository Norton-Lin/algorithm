package leetcode_2530;
/*
 * @lc app=leetcode.cn id=2530 lang=java
 *
 * [2530] 执行 K 次操作后的最大分数
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    //优先队列+贪心
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        long ans = 0;
        int cur = 0;
        for(int i = 0;i<nums.length;++i)
        {
            queue.offer(nums[i]);
        }
        while(k>0)
        {
            cur = queue.poll();
            ans+=cur;
            if(cur%3==0)
                cur/=3;
            else
                cur=cur/3+1;
            queue.offer(cur);
            --k;
        }
        return ans;
    }
}
// @lc code=end

