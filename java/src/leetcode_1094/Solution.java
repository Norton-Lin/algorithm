/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    //一次遍历，模拟
    //到位置下人，用数组存储
    //数组长度不足1000
    public boolean carPooling(int[][] trips, int capacity) {
        int len = 0;
        for(int i = 0;i<trips.length;++i)
            len = Math.max(len,trips[i][2]);
        int from[] = new int[len+1];
        int to[] = new int[len+1];
        for(int[] arr: trips){
            from[arr[1]] += arr[0];
            to[arr[2]] += arr[0];
        }
        for(int i = 0;i<len;++i){
            capacity+=to[i];
            capacity-=from[i];
            if(capacity<0)
                return false;
        }
        return true;
    }
}
// @lc code=end

