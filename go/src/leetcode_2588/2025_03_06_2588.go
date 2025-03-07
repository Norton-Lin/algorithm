package main

/*
 * @lc app=leetcode.cn id=2588 lang=golang
 *
 * [2588] 统计美丽子数组数目
 */

// @lc code=start
// dp 以dp结尾的数组有多少个美丽数组
// 异或
// 二重循环复杂度爆炸
// 哈希记录
func BeautifulSubarrays(nums []int) int64 {
	ans := int64(0)
	cur := 0
	prefix := make(map[int]int)
	prefix[0] = 1
	for _, num := range nums {
		cur ^= num
		ans += int64(prefix[cur])
		prefix[cur]++

	}
	return ans
}

// @lc code=end
