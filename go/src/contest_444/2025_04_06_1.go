package contest_444

// 数组变成非递减
// 每次转换最小的相邻数
func MinimumPairRemoval(nums []int) int {
	ans := 0

	for !check(nums) {
		n := len(nums)
		cur := nums[0] + nums[1]
		index := 0
		for i := 1; i < n-1; i++ {
			if cur > nums[i]+nums[i+1] {
				cur = nums[i] + nums[i+1]
				index = i
			}
		}
		nums[index] += nums[index+1]
		nums = append(nums[0:index+1], nums[index+2:]...)
		ans++
	}

	return ans
}
func check(nums []int) bool {
	pre := nums[0] - 1
	ans := true
	for _, num := range nums {
		if num < pre {
			ans = false
			break
		}
		pre = num
	}
	return ans
}
