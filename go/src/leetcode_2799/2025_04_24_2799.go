package main

/*
 * @lc app=leetcode.cn id=2799 lang=golang
 *
 * [2799] 统计完全子数组的数目
 */

// @lc code=start
// 完全子数组：子数组不同元素等于原数组：哈希记录
// 滑动窗口： 某个位置开始的子数组如果是完全的，同一位置开始比他长也是完全的
// O(n)
func CountCompleteSubarrays(nums []int) int {
	sum := 0
	ans := 0
	n := len(nums)
	left, right := 0, 0
	records := make(map[int]int)
	for _, num := range nums {
		records[num]++
	}
	sum = len(records)
	records = make(map[int]int)
	for ; right < sum; right++ {
		records[nums[right]]++
	}
	//fmt.Println(records, left, right)
	for left <= n-sum {
		if len(records) == sum {
			ans += n - right + 1
			//fmt.Println(ans)
			if records[nums[left]] == 1 {
				delete(records, nums[left])
			} else {
				records[nums[left]]--
			}
			left++
		} else {
			if right == n {
				left++
				continue
			}
			records[nums[right]]++
			right++
		}
	}
	if len(records) == sum {
		ans++
	}
	return ans
}

// @lc code=end
