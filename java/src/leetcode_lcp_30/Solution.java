package leetcode_lcp_30;

import java.util.PriorityQueue;

class Solution {
    // 再还没有小于0时就进行移动
    public int magicTower(int[] nums) {
        long sum = 0;
        long cur = 0;
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num: nums)
            sum+=num;
        if(sum<0)//提前判断更快
            return -1;
        for(int num: nums){
            cur+=num;
            if(num<0)
                queue.offer(num);
            if(cur<0){
                cur-=queue.poll();
                ++ans;
            }
        }
        return ans;
    }
}
