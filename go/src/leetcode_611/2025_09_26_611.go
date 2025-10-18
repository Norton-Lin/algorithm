package main

import "sort"

/*
 * @lc app=leetcode.cn id=611 lang=golang
 *
 * [611] 有效三角形的个数
 */

// @lc code=start
func triangleNumber(nums []int) int {
	ans := 0
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	//fmt.Println(nums)
	for i := 0; i < len(nums)-2; i++ {
		k := i + 1
		for j := i + 1; j < len(nums)-1; j++ {
			if k < j {
				k = j + 1
			}
			for ; k < len(nums) && nums[i]+nums[j] > nums[k]; k++ {

			}
			// if k < len(nums)&&nums[i]+nums[j]<=nums[k]{
			//     continue
			// }
			if k == j {
				continue
			}
			ans += k - j - 1
		}
	}
	return ans
}

// @lc code=end
