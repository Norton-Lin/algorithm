package contest472

func LongestBalanced(nums []int) int {
	ans := 0
	n := len(nums)
	for i := 0; i < n; i++ {
		set1 := make(map[int]int)
		set2 := make(map[int]int)
		for j := i; j < n; j++ {
			if nums[j]%2 == 0 {
				set1[nums[j]]++
			} else {
				set2[nums[j]]++
			}
			if len(set1) == len(set2) {
				ans = max(ans, j-i+1)
			}
		}
	}
	return ans
}
