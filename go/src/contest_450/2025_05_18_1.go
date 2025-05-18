package contest450

func smallestIndex(nums []int) int {
	n := len(nums)
	ans := -1
	for i := 0; i < n; i++ {
		cur := 0
		for nums[i] > 0 {
			cur += nums[i] % 10
			nums[i] /= 10
		}
		if cur == i {
			ans = i
			break
		}
	}
	return ans
}
