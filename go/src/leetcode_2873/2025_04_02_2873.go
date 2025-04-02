package main

/*
 * @lc app=leetcode.cn id=2873 lang=golang
 *
 * [2873] 有序三元组中的最大值 I
 */

// @lc code=start
// (i,j,k) ans = max(nums[i] - nums[j]) * nums[k])
// i < j < k, 所有nums大于0
// 遍历j,选两侧的最大i,k
// 两个最大值辅助数组记录nums[i],nums[k]
// 时间O(2n) 空间O(2n)
// 进一步优化
// 遍历k的时候记录i或k,省一个辅助数组
// 时间O(2n) 空间O(n)
// 更进一步优化 双指针
func MaximumTripletValue(nums []int) int64 {
	var ans, maxDiff, preMax int
	for _, x := range nums {
		ans = max(ans, maxDiff*x)        //遍历k
		maxDiff = max(maxDiff, preMax-x) //记录i ,j差值
		preMax = max(preMax, x)          //把k加入更新作为新的i
	}
	return int64(ans)
}

// 单辅助数组
// func MaximumTripletValue(nums []int) int64 {
// 	n := len(nums)
// 	ans, left := int64(0), int64(0)
// 	right := make([]int, n)
// 	right[n-1] = 0
// 	for k := n - 2; k >= 0; k-- {
// 		right[k] = max(right[k+1], nums[k+1])

// 	}
// 	for j := 1; j < n-1; j++ {
// 		left = max(int64(nums[j-1]), left)
// 		if left > int64(nums[j]) {
// 			ans = max(ans, (left-int64(nums[j]))*int64(right[j]))
// 		}
// 		//fmt.Println(left[j],nums[j],right[j])
// 	}
// 	return ans
// }
// 双辅助数组
// func MaximumTripletValue(nums []int) int64 {
// 	n := len(nums)
// 	ans := int64(0)
// 	left, right := make([]int, n), make([]int, n)
// 	right[n-1] = 0
// 	left[0] = 0
// 	for i := 1; i < n; i++ {
// 		right[n-i-1] = max(right[n-i], nums[n-i])
// 		left[i] = max(left[i-1], nums[i-1])
// 	}
// 	for j := 1; j < n-1; j++ {
// 		if left[j] > nums[j] {
// 			ans = max(ans, (int64(left[j])-int64(nums[j]))*int64(right[j]))
// 		}
// 		//fmt.Println(left[j],nums[j],right[j])
// 	}
// 	return ans
// }

// @lc code=end
