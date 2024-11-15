package main

/*
 * @lc app=leetcode.cn id=3254 lang=golang
 *
 * [3254] 长度为 K 的子数组的能量值 I
 */

// @lc code=start
// 往前看 k个是否连续单增
// 优化，出现一个不连续，后续k-2个必然为 -1
func ResultsArray(nums []int, k int) []int {
	n := len(nums)
	ans := make([]int, n-k+1)
	i := 1
	for ;i<k;i++{
		if nums[i]!=nums[i-1]+1{
			ans[0] = -1
			break;
		}
	}
	if ans[0] != -1 {
		ans[0] = nums[i-1]
	}
	for i=k;i < n ;i++{
		ans[i-k+1] = -1
		j := i-1
		for ;j>i-k;j--{
			if(nums[j+1] != nums[j]+1){
				break
			}
		}
		if j == i - k  {
			ans[i-k+1] = nums[i]
		}
	}
	return ans
}

// @lc code=end
