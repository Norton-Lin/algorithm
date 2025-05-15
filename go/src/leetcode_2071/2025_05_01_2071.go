package main

import (
	"slices"
	"sort"
)

/*
 * @lc app=leetcode.cn id=2071 lang=golang
 *
 * [2071] 你可以安排的最多任务数目
 */

// @lc code=start
// 每个worker最多增加strength
// 每个worker最多对应一个task
// 有pills个worker可以增加strength
// 如果有工人可以不使用药丸完成该任务，那么我们选择（删除）值最大的工人；
// 如果所有工人都需要使用药丸才能完成该任务，那么我们选择（删除）值最小的工人。
func MaxTaskAssign(tasks, workers []int, pills, strength int) int {
	slices.Sort(tasks)
	slices.Sort(workers)
	m := len(workers)
	ans := sort.Search(min(len(tasks), m), func(k int) bool {
		k++
		// 贪心：用最强的 k 名工人，完成最简单的 k 个任务
		i, p := 0, pills
		validTasks := []int{}
		for _, w := range workers[m-k:] { // 枚举工人
			// 在吃药的情况下，把能完成的任务记录到 validTasks 中
			for ; i < k && tasks[i] <= w+strength; i++ {
				validTasks = append(validTasks, tasks[i])
			}
			// 即使吃药也无法完成任务
			if len(validTasks) == 0 {
				return true
			}
			// 无需吃药就能完成（最简单的）任务
			if w >= validTasks[0] {
				validTasks = validTasks[1:]
				continue
			}
			// 必须吃药
			if p == 0 { // 没药了
				return true
			}
			p--
			// 完成（能完成的）最难的任务
			validTasks = validTasks[:len(validTasks)-1]
		}
		return false
	})
	return ans
}

// @lc code=end
