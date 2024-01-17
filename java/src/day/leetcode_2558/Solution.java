package day.leetcode_2558;
/*
 * @lc app=leetcode.cn id=2558 lang=java
 *
 * [2558] 从数量最多的堆取走礼物
 */

// @lc code=start
import java.util.PriorityQueue;

class Solution {
    //优先队列，开根号
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        int cur = 0;
        for(int i = 0;i<gifts.length;++i){
            queue.offer(gifts[i]);
        }
        while(k>0){
            cur = queue.poll();
            queue.offer((int)Math.sqrt(cur));
            --k;
        }
        while(!queue.isEmpty())
            ans+=queue.poll();
        return ans;
    }
    public static void main(String args[]){
        Solution s =new Solution();
        s.pickGifts(new int[]{25,64,9,4,100}, 4);
    }
}
// @lc code=end

