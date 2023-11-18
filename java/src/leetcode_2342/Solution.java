/*
 * @lc app=leetcode.cn id=2342 lang=java
 *
 * [2342] 数位和相等数对的最大和
 */

// @lc code=start
package leetcode_2342;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    // 最大堆
    // 实际上只需要维护两个值
    /**
    public int maximumSum(int[] nums) {
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int ans = -1;
        int cur = 0,key = 0;
        for(int i: nums){
            cur = i;
            key = 0;
            while(cur != 0){
                key+=cur%10;
                cur/=10;
            }
            //最大堆
            PriorityQueue<Integer> value = map.getOrDefault(key, new PriorityQueue<>((a,b)->b-a));
            if(!value.isEmpty())
                ans = Math.max(value.peek()+i,ans);
            value.offer(i);
            map.put(key, value);
        }
        return ans;
    }
     */
    public int maximumSum(int[] nums){
        Map<Integer,int[]> map = new HashMap<>();
        int[] arr;
        int ans = -1;
        int cur = 0,key = 0;
        for(int i: nums){
            cur = i;
            key = 0;
            while(cur != 0){
                key+=cur%10;
                cur/=10;
            }
            if(map.containsKey(key))
                arr = map.get(key);
            else
                arr = new int[2];
            if(arr[0] == 0)
                arr[0] = i;
            else if(arr[1]<i){
                if(arr[0]<i){
                    arr[1] = arr[0];
                    arr[0] = i;
                }
                else
                    arr[1] = i;
                ans = Math.max(arr[0]+arr[1],ans);
            }
            map.put(key,arr);
        }
        return ans;
    }
    /** 大佬的超级优化 -- 数组代替哈希
    public int maximumSum(int[] nums) {
        int[] val = new int[100];
        int ans = -1;
        for (int x : nums) {
            int t = x, cur = 0;
            while (t != 0) {
                cur += t % 10;
                t /= 10;
            }
            if (val[cur] != 0) ans = Math.max(ans, val[cur] + x);
            val[cur] = Math.max(val[cur], x);
        }
        return ans;       
    }
     */
}

// @lc code=end
