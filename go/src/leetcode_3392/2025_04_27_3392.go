package main

func CountSubarrays(nums []int) int {
	ans := 0
	left, right := 0, 2
	n := len(nums)
	for ; right < n; left, right = left+1, right+1 {
		if (nums[left]+nums[right])*2 == nums[right-1] {
			ans++
		}
	}
	return ans
}
