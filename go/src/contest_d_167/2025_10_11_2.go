package contestd167

func LongestSubarray(nums []int) int {
	n := len(nums)
	dp := make([]int, n)
	dp[0] = 1
	dp[1] = 2
	ans := 2
	for i := 2; i < n; i++ {
		if nums[i] == nums[i-1]+nums[i-2] {
			dp[i] = dp[i-1] + 1
		} else {
			dp[i] = 2
		}
		ans = max(ans, dp[i])
	}
	return ans
}
