package contest453

import "container/heap"

type Item struct {
	value int
	index int
}
type PriorityQueue1 []Item

func (p PriorityQueue1) Len() int {
	return len(p)
}

func (p PriorityQueue1) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p PriorityQueue1) Less(i, j int) bool {
	return p[i].value < p[j].value
}
func (p *PriorityQueue1) Pop() interface{} {
	old := *p
	n := len(old)
	res := old[n-1]
	*p = old[0 : n-1]
	return res
}
func (p *PriorityQueue1) Push(x interface{}) {
	*p = append(*p, x.(Item))
}

type PriorityQueue2 []Item

func (p PriorityQueue2) Len() int {
	return len(p)
}

func (p PriorityQueue2) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p PriorityQueue2) Less(i, j int) bool {
	return p[i].value > p[j].value
}
func (p *PriorityQueue2) Pop() interface{} {
	old := *p
	n := len(old)
	res := old[n-1]
	*p = old[0 : n-1]
	return res
}
func (p *PriorityQueue2) Push(x interface{}) {
	*p = append(*p, x.(Item))
}

// 分割数组，每个数组子段的最大差值不超过k
// dp?
func countPartitions(nums []int, k int) int {
	n := len(nums)
	mod := 1_000_000_000 + 7
	dp := make([]int, n+1)
	records := make([]int, n+1)
	maxQueue := &PriorityQueue1{}
	minQueue := &PriorityQueue2{}
	pre := 0
	dp[0] = 1
	records[0] = dp[0]
	for i := 1; i <= n; i++ {
		dp[i] = dp[i-1]
		
		dp[i] = records[i-1] - records[pre]
		records[i] = dp[i] + records[i-1]
		heap.Push(minQueue, nums[i-1])
		heap.Push(maxQueue, nums[i-1])

	}
	return dp[n]
}
