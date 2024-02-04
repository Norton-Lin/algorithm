package day.leetcode_1686;

/*
 * @lc app=leetcode.cn id=1686 lang=java
 *
 * [1686] 石子游戏 VI
 */
import java.util.Comparator;
import java.util.PriorityQueue;
// @lc code=start

class Solution {
    // 双方评判策略不同，A先拿
    // A采用最优策略，每次拿更有利自己的
    // 选 a[i] + b[i] 大的
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int value = 0;
        boolean judge = true;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (b[0] + b[1]) - (a[0] + a[1]);
            }
        });
        for (int i = 0; i < aliceValues.length; ++i) {
            int[] temp = new int[2];
            temp[0] = aliceValues[i];
            temp[1] = bobValues[i];
            queue.offer(temp);
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (judge)
                value += cur[0];
            else
                value -= cur[1];
            judge = !judge;
        }
        if (value == 0)
            return 0;
        return value > 0 ? 1 : -1;
    }
    /**
     * 优化
     * class Solution {
     * public int stoneGameVI(int[] aliceValues, int[] bobValues) {
     * int n = aliceValues.length;
     * int[][] values = new int[n][3];
     * for (int i = 0; i < n; i++) {
     * values[i][0] = aliceValues[i] + bobValues[i];
     * values[i][1] = aliceValues[i];
     * values[i][2] = bobValues[i];
     * }
     * Arrays.sort(values, (a, b) -> b[0] - a[0]);
     * int aliceSum = 0, bobSum = 0;
     * for (int i = 0; i < n; i++) {
     * if (i % 2 == 0) {
     * aliceSum += values[i][1];
     * } else {
     * bobSum += values[i][2];
     * }
     * }
     * if (aliceSum > bobSum) {
     * return 1;
     * } else if (aliceSum == bobSum) {
     * return 0;
     * } else {
     * return -1;
     * }
     * }
     * }
     */
}
// @lc code=end
