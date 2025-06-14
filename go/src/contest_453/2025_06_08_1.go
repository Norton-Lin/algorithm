package contest453

//对相邻元素操作
func CanMakeEqual(nums []int, k int) bool {
	cur1, cur2 := 0, 0
	n := len(nums) - 1
	nums1 := make([]int, n)
	copy(nums1, nums)
	for i := 0; i < n-1 && cur1 <= k; i++ {
		if nums[i] == -1 {
			nums[i+1] *= (-1)
			cur1++
		}
	}
	if nums[n-1] == -1 {
		cur1 = k + 1
	}
	for i := 0; i < n-1 && cur2 <= k; i++ {
		if nums1[i] == 1 {
			nums1[i+1] *= (-1)
			cur2++
		}
	}
	if nums1[n-1] == 1 {
		cur2 = k + 1
	}
	return cur1 <= k || cur2 <= k
}
