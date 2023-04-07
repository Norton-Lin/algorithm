package leetcode_1040;

import java.util.Arrays;

class Solution {
    //只移动端点石子
    //使端点石子不再是端点
    //一个端点恒为端点，      
    //max，逐个放置,长为size的区间，石头个数最少
    //min 长为size的区间，石头个数最多的m ans = size - m
    //若有一个孤立端点，+1
    //双指针
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        if (stones[n - 1] - stones[0] + 1 == n)//一开始就连续
            return new int[]{0, 0};
        //stone[n-1] - stone[1] + 1 - (n-1) 第一次移动stone[0],之后的可移动次数
        //stone[n-2] - stone[0] + 1 - (n-1) 第一次移动stone[n-1],之后的可移动次数
        //不断从左/从右
        int ma = Math.max(stones[n - 2] - stones[0] + 1, stones[n - 1] - stones[1] + 1) - (n - 1);
        int mi = n;
        for (int i = 0, j = 0; i < n && j + 1 < n; ++i) {
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                ++j;
            }//两个石子间间隔过大
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                mi = Math.min(mi, 2);//区间填满
            } else {
                mi = Math.min(mi, n - (j - i + 1));
            }
        }
        return new int[]{mi, ma};
    }
}

