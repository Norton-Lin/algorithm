package main

/*
 * @lc app=leetcode.cn id=2555 lang=golang
 *
 * [2555] 两个线段获得的最多奖品
 */

// @lc code=start
//	prizePositions非递减 表示奖品位置
//	获取prizePositions 值最多的区间
//  区间要尽可能覆盖整个prizePositions数组
//  求：双区间并集最大
//  双指针找区间，区间组合
//  dp[i]线段起点
//  prefix记录每个数第一次出现
//  suffix记录每个数最后一次出现
//  区间 i ， j 得到的值为 suffix[j] - prefix[i]
//  两组区间 i,j k,l有两种可能
//  suffix[j] - prefix[i] + suffix[l] - prefix[k]
//  suffix[l] - prefix[i] (k<=j) 这种情况不可能，可以左移
//  lowerboud 找不小于key - k 的最大值
//  滑动窗口
//  记 第二条线段起点是 i ,第一条线段能覆盖的奖品长度是record[i]
//  record[i+1] = max(record[i] + 1, i-left+1) 这里的left指第一条线段的起点
func maximizeWin(prizePositions []int, k int) int {
	ans := 0
	n := len(prizePositions)
	//窗口足够覆盖
	if 2*k+1 >= prizePositions[n-1]-prizePositions[0] {
		return n
	}
	record := make([]int, n+1)
	record[0] = 0
	left := 0
	for right, value := range prizePositions {
		for value-prizePositions[left] > k { //比区间大
			left++
		}
		ans = max(ans, record[left]+right-left+1)
		record[right+1] = max(record[right], right-left+1)
	}
	return ans
}

// @lc code=end
