package contest440

import (
	"container/heap"
	"fmt"
	"sort"
)

// 找出所有满足 nums1[j] 小于 nums1[i] 的下标 j，j<n
// 从对应的nums[j]中选出k个
// 三维数组排序
// 优先队列，维护最大的k个值
type PriorityQueue []int64

func (p PriorityQueue) Len() int {
	return len(p)
}
func (p PriorityQueue) Less(i, j int) bool {
	return p[i] > p[j]
}
func (p PriorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p *PriorityQueue) Pop() interface{} {
	old := *p
	n := len(old)
	item := old[n-1]
	*p = old[0 : n-1]
	return item
}
func (p *PriorityQueue) Push(x interface{}) {
	*p = append(*p, x.(int64))
}
func findMaxSum(nums1 []int, nums2 []int, k int) []int64 {
	n := len(nums1)
	ans := make([]int64, n)
	record := make([][]int, n)
	for i := 0; i < n; i++ {
		record[i] = make([]int, 3)
		record[i] = []int{nums1[i], nums2[i], i}
	}
	sort.Slice(record, func(i, j int) bool {
		if record[i][0] == record[j][0] {
			return record[i][1] > record[j][1]
		}
		return record[i][0] > record[j][0]
	})
	fmt.Println(record)

	queue := &PriorityQueue{}
	staff := make([]int64, 0)
	staff = append(staff, int64(record[0][1]))
	sum := int64(0)
	for i := 1; i < n; i++ {
		// 还不能入队
		if record[i][0] == record[i-1][0] {
			staff = append(staff, int64(record[i-1][1]))
		} else { //等值元素可以入队
			for queue.Len() < k && len(staff) > 0 {
				heap.Push(queue, staff[0])
				staff = staff[1:]
			}
			if queue.Len() >= k {
				top := heap.Pop(queue).(int64)
				for _, num := range staff {
					if num > top {
						sum = sum + num - top
						heap.Push(queue, num)
						top = heap.Pop(queue).(int64)
					}
				}
				heap.Push(queue, top)
			}
			staff = make([]int64, 0)
		}
		ans[record[i][2]] = sum
	}
	return ans
}
