package day.leetcode_1488;
/*
 * @lc app=leetcode.cn id=1488 lang=java
 *
 * [1488] 避免洪水泛滥
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

// @lc code=start
class Solution {
    // 下雨后 空湖泊就变满 ，满湖泊洪水
    // rain[i]>0 第i天第rain[i]个湖泊下雨
    // rain[i]==0 第i天没有湖泊下雨,可以抽干一个湖泊
    // 返回ans[],ans[i]表示第i天抽干的湖泊,没有抽干就是-1
    // 要在一个满湖泊下雨前抽干，有点像死锁算法?
    // 记录可以抽水的次数，再记录每个湖泊下次下雨的时间？
    // 暴力解法1
    /**
    public int[] avoidFlood(int[] rains) {
        int ans[] = new int[rains.length];
        int cur;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Queue<Integer>> records = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < rains.length; ++i) {
            Queue<Integer> record;
            if (records.containsKey(rains[i]))
            {
                record = records.get(rains[i]);
                record.add(i);
            }
            else 
                record = new LinkedList<>();
            records.put(rains[i], record);
        }
        for (int i = 0;i<rains.length;++i)
        {
            if(rains[i]>0)
            {
                ans[i] = -1;
                if(set.contains(rains[i]))
                {
                    return new int[0];
                }
                set.add(rains[i]);
                Queue<Integer> record;
                record = records.get(rains[i]);
                if(!record.isEmpty())
                {
                    queue.offer(record.poll());
                    records.put(rains[i], record);
                }
            }
            else{
                if(queue.isEmpty())
                    ans[i] = 1;
                else{
                    cur = queue.poll();
                    while(!set.contains(rains[cur])&&!queue.isEmpty())
                        cur = queue.poll();
                    ans[i] = rains[cur];
                    set.remove(rains[cur]);
                }
            }
        }
        return ans;
    }
     */
    // 优化 贪心+二分查找
    // 时间O(nlogn) 空间 O(n)
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        TreeSet<Integer> st = new TreeSet<Integer>();//存储晴天
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) {
                st.add(i);
            } else {
                ans[i] = -1;
                if (mp.containsKey(rains[i])) {
                    Integer it = st.ceiling(mp.get(rains[i]));//获取比i大的最小值
                    //即找到该湖泊上次下雨之后的第一个晴天
                    if (it == null) {
                        return new int[0];
                    }
                    ans[it] = rains[i];
                    st.remove(it);
                }
                mp.put(rains[i], i);
            }
        }
        return ans;
    }
}
// @lc code=end
