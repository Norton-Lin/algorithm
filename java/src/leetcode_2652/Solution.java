package leetcode_2652;
/*
 * @lc app=leetcode.cn id=2652 lang=java
 *
 * [2652] 倍数求和
 */

// @lc code=start
class Solution {
    //暴力匹配
    /**
    public int sumOfMultiples(int n) {
        int sum = 0;
        for(int i = 3;i<=n;++i)
        {
            if(i%3==0||i%5==0||i%7==0)
                sum+=i;
        }
        return sum;
    }*/
    //容斥原理
    public int f(int n, int m) {
        return (m + n / m * m) * (n / m) / 2;
    }
    
    public int sumOfMultiples(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
    }

}
// @lc code=end

