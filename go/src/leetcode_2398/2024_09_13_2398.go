package main

/*
 * @lc app=leetcode.cn id=2398 lang=golang
 *
 * [2398] 预算内的最多机器人数目
 */

// @lc code=start
// k越小，chargeTime权值越高
// k越大，runningCost权值越高
// max(chargeTimes) + k * sum(runningCost)
// 或者k*sum(runningCost) + sum(chargeTimes) - sum(ChargeTimes) + max(chargeTimes)
// sum增加值大于charge的，选增charge
// 0 1 背包？
// 连续运行 数组必须连续
// 保证窗口大小，然后后移
// 维护窗口内charge最大值
// 区间值为 max + （right-left+1）*（sum/（right-left） + num）
func maximumRobots(chargeTimes []int, runningCosts []int, budget int64) int {
	ans := 0
	q := []int{}
	var sum int64 = 0
	left := 0
	for right, charge := range chargeTimes {
		//入队
		for len(q) > 0 && charge >= chargeTimes[len(q)-1] {
			q = q[:len(q)-1]
		}
		q = append(q, right)
		sum += int64(runningCosts[right])
		for len(q) > 0 && int64(chargeTimes[q[0]])+int64(right-left+1)*sum > budget {
			if q[0] == left {
				q = q[1:]
			}
			sum -= int64(runningCosts[left])
			left++
		}
		ans = max(ans, right-left+1)
	}
	return ans
}

// @lc code=end
