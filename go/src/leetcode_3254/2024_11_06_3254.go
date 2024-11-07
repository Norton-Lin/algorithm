package main

/*
 * @lc app=leetcode.cn id=3254 lang=golang
 *
 * [3254] 长度为 K 的子数组的能量值 I
 */

// @lc code=start
// 一个中断接下来k个中断
// 上一个连续，新数字也连续，新数组连续
// if dp[i-1] != -1 && nums[i+k] == nums[i-1]+k+1
// dp[i] = do[i-1]+1
// else dp[i] = -1
func ResultsArray(nums []int, k int) []int {
	n := len(nums)
	ans := make([]int, n-k+1)
	i := 1
	for ; i < k; i++ {
		if nums[i] != nums[i-1]+1 {
			ans[0] = -1
			break
		}
	}
	if ans[0] != -1 {
		ans[0] = nums[i-1]
	}
	for i = k; i < n; i++ {
		ans[i-k+1] = -1
		j := i - 1
		for ; j > i-k; j-- {
			//fmt.Println(nums[j],nums[j+1])
			if nums[j+1] != nums[j]+1 {
				break
			}
		}
		if j == i-k {
			ans[i-k+1] = nums[i]
		}
	}
	return ans
}

// @lc code=end
