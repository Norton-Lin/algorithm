package leetcode_2517;

import java.util.Arrays;

class Solution {
	//找最大甜蜜度
	//甜蜜度：k个元素中，两两相减的绝对值最小值
	//必然不能暴力枚举
	//price中，找到k个元素，其甜蜜值最大
	//dp 第i个元素，做第j个被选元素，dp[i][j]记录此时甜蜜度
	//dp[i][j] = Math.min(price[i] - price[m],dp[m][j-1]) j<m<i
	//可能存在多种最优解，但是最优解绝对含选头尾
	/**
	public int maximumTastiness(int[] price, int k) {
    	Arrays.sort(price);//price由小到大排列，挑选k个元素，dp
    	int[]dp1 = new int[price.length];
        int[]dp2 = new int[price.length];
    	int cur = 0;
        Arrays.fill(dp1,Integer.MAX_VALUE);
    	for(int i = 1;i<k;++i)
        {
            for(int j =1; j<price.length;++j)
            {
                cur = 0;
                for(int m= j-1;m>=i-1;--m)
                {
                    cur = Math.max(cur,Math.min(price[j]-price[m],dp1[m]));
                }
                dp2[j] = cur;
            }
            for(int j = 0;j<price.length;++j)
            	dp1[j] = dp2[j];
        }
    	return dp1[price.length-1];
    }*/
	//贪心 + 二分
	//在假设一个甜蜜度mid 后，在排好序的 price 中找 k 种糖果时，需要用到贪心的算法。
	//即从小到大遍历 price 的元素，如果当前糖果的价格比上一个选中的糖果的价格的差大于 
	//mid，则选中当前糖果，否则继续考察下一个糖果。

	//二分查找起始时，下边界为 0，上边界为 price 的最大值与最小值之差。二分查找结束时，即可得到最大甜蜜度。

	public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = (price[price.length - 1] - price[0]) / (k - 1) + 1;
        while (left + 1 < right) { // 开区间不为空
            // 循环不变量：
            // f(left) >= k
            // f(right) < k
            int mid = left + (right - left) / 2;
            if (f(price, mid) >= k) left = mid; // 下一轮二分 (mid, right)
            else right = mid; // 下一轮二分 (left, mid)
        }
        return left;
    }

    private int f(int[] price, int d) {
        int cnt = 1, pre = price[0];
        for (int p : price) {
            if (p >= pre + d) {
                cnt++;
                pre = p;
            }
        }
        return cnt;
    }
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int ans = solution.maximumTastiness(new int[] {13,5,1,8,21,2}, 3);
    	System.out.print(ans);
    }
}
