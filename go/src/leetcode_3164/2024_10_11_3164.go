package main

/*
 * @lc app=leetcode.cn id=3164 lang=golang
 *
 * [3164] 优质数对的总数 II
 */

// @lc code=start
// 优质数对中，nums1必然可以被k整除
// 记录倍数还是更快 比遍历快
func numberOfPairs(nums1 []int, nums2 []int, k int) int64 {
	count1 := make(map[int]int64)
	count2 := make(map[int]int64)
	ans := int64(0)
	max := 0
	// 统计数量和最大值
	for _, num := range nums1 {
		if num%k == 0 {
			count1[num/k]++
			if num/k > max {
				max = num / k
			}
		}
	}
	for _, num := range nums2 {
		count2[num]++
	}
	// 对num2 遍历其倍数
	for num2, cnt2 := range count2 {
		for i := num2; i <= max; i += num2 {
			if _, ok := count1[i]; ok {
				ans += cnt2 * count1[i]
			}
		}
	}
	return ans
}

// @lc code=end
