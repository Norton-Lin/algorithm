package day.leetcode_2009;
import java.util.ArrayDeque;
/*
 * @lc app=leetcode.cn id=2009 lang=java
 *
 * [2009] 使数组连续的最少操作数
 */
import java.util.Arrays;
import java.util.Deque;
// @lc code=start
class Solution {
    //最大最小差应为nums.length-1，且元素不同
    //如果元素重复，必然要操作
    //然后看窗口内的元素数量 窗口双指针
    //排序
    //双指针取代queue可以提速
    public int minOperations(int[] nums) {
        //index的移动规则决定了窗口内肯定有一个
        int num = 1;//窗口内元素数量,要统计窗口内的重复数量
        int n = nums.length;
        Arrays.sort(nums);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(nums[0]);
        int index = 1;
        for(int i = 0;i<n&&index<n;++i){
            int max = nums[i] + n - 1;
            if(nums[i]!=queue.peekFirst())//窗口外元素出队
                queue.pollFirst();
            while(index<n&&nums[index]<=max){
                if(queue.isEmpty()||queue.peekLast()!=nums[index])//添加不重复元素
                    queue.offerLast(nums[index]);
                ++index;
            }
            num = Math.max(num,queue.size());
        }
        return n-num;//全部元素，去掉最多的窗口内非重复元素数量就是答案
    }
}
// @lc code=end

