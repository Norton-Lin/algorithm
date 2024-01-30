/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */
package day.leetcode_365;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// @lc code=start
class Solution {
    // 判断能否通过两个水壶，得到target
    // 允许三个操作，装满，清空，倒入
    // 统计所有的可能，判断是否存在target
    // target的组成有以下两种：
    // 1. 单个水壶 2. 两个水壶相加
    // 每个结点进行以下操作：
    // 1.B倒A B装满，不动，清空
    // 2.A倒B A装满，不动，清空
    // 出现重复A,B的时候，停止向下搜索
    /**
     * Map<Integer,Set<Integer>> map;
     * public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int
     * targetCapacity) {
     * if(jug1Capacity<jug2Capacity){
     * int temp = jug1Capacity;
     * jug1Capacity = jug2Capacity;
     * jug2Capacity = temp;
     * }
     * map = new HashMap<>();
     * return dfs(jug1Capacity, jug2Capacity,jug1Capacity, jug2Capacity,
     * targetCapacity);
     * }
     * //cap1 必然比 jug2 大
     * public boolean dfs(int cap1, int cap2, int jug1, int jug2, int target){
     * //有解
     * if(jug1 == target || jug2 == target || jug1 + jug2 == target)
     * return true;
     * //该情况已搜索
     * if(map.containsKey(jug1)){
     * if(map.get(jug1).contains(jug2))
     * return false;
     * }
     * Set<Integer> value = map.getOrDefault(jug1, new HashSet<>());
     * value.add(jug2);
     * map.put(jug1, value);
     * boolean ans = false;
     * int record1 = jug1;
     * int record2 = jug2;
     * if(jug1 + jug2 > cap1){
     * jug2 = jug1 + jug2 - cap1;
     * jug1 = cap1;
     * }
     * else{
     * jug1 += jug2;
     * jug2 = 0;
     * }
     * // B灌A
     * ans = dfs(cap1, cap2, jug1, jug2, target);
     * if(ans)
     * return ans;
     * // B灌满
     * ans = dfs(cap1, cap2, record1, cap2, target);
     * if(ans)
     * return ans;
     * // B清空
     * ans = dfs(cap1, cap2, record1, 0, target);
     * if(ans)
     * return ans;
     * jug1 = record1;
     * jug2 = record2;
     * if(jug1 + jug2 > cap2){
     * jug1 = jug1 + jug2 - cap2;
     * jug2 = cap2;
     * }
     * else{
     * jug2 += jug1;
     * jug1 = 0;
     * }
     * ans = dfs(cap1, cap2, jug1, jug2, target);
     * if(ans)
     * return ans;
     * ans = dfs(cap1, cap2, cap1, record2, target);
     * if(ans)
     * return ans;
     * ans = dfs(cap1, cap2, 0, record2, target);
     * if(ans)
     * return ans;
     * return false;
     * }
     */
    //轮转 裴蜀定理
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity)
            return false;
        if (jug1Capacity + jug2Capacity == targetCapacity)
            return true;
        int bigJug = Math.max(jug1Capacity, jug2Capacity);
        int smallJug = bigJug == jug1Capacity ? jug2Capacity : jug1Capacity;
        int curJugB = bigJug, curJugS = 0;
        while (true) {
            if (curJugB == targetCapacity)
                return true;
            int smallJugRemain = smallJug - curJugS;
            if (curJugB >= smallJugRemain) {
                curJugS = 0;
                curJugB -= smallJugRemain;
                if (curJugB == 0)
                    return false;
            } else {
                curJugS += curJugB;
                curJugB = bigJug;
                if (curJugB + curJugS == targetCapacity)
                    return true;
            }
        }
    }

}
// @lc code=end
