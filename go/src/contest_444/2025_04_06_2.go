package contest_444

import (
	"container/heap"
	"fmt"
	"sort"
)

type Record struct {
	source      int
	destination int
	timestamp   int
}
type RecordQueue struct {
	source      int
	destination int
	timestamp   int
	count       int
}
type Router struct {
	memoryLimit int
	queue       PriorityQueue
	records     map[Record]bool       //哈希记录
	soureQueue  map[int]PriorityQueue //分组记录
}
type PriorityQueue []RecordQueue

var lcount int = 0

func (p PriorityQueue) Len() int {
	return len(p)
}
func (p PriorityQueue) Less(i, j int) bool {
	if p[i].timestamp == p[j].timestamp {
		return p[i].count < p[j].count
	}
	return p[i].timestamp <= p[j].timestamp
}
func (p PriorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}

func (p *PriorityQueue) Push(x interface{}) {
	*p = append(*p, x.(RecordQueue))
}
func (p *PriorityQueue) Pop() interface{} {
	old := *p
	n := len(old)
	res := old[n-1]
	*p = old[0 : n-1]
	return res
}

// hash记录包是否存在，priorityqueue记录顺序
// 超过memoryLimit,移除最老的
func Constructor(memoryLimit int) Router {
	return Router{memoryLimit, make(PriorityQueue, 0), make(map[Record]bool), make(map[int]PriorityQueue)}
}

// 重复包不添加
// 达到上限移除老包，priorityqueue出队 hash移除
func (this *Router) AddPacket(source int, destination int, timestamp int) bool {
	lcount++
	cur := RecordQueue{source, destination, timestamp, lcount}
	key := Record{source, destination, timestamp}
	if ok := this.records[key]; ok {
		return false
	}
	if len(this.queue) == this.memoryLimit {
		top := heap.Pop(&this.queue).(RecordQueue)
		delete(this.records, Record{top.source, top.destination, top.timestamp})
		des := this.soureQueue[top.destination]
		heap.Pop(&des)
		this.soureQueue[top.destination] = des
	}
	heap.Push(&this.queue, cur)
	queue := this.soureQueue[destination]
	heap.Push(&queue, cur)
	this.soureQueue[destination] = queue
	this.records[key] = true
	fmt.Println(this)
	return true
}

// 移除第一个，priorityqueue出队，hash移除
func (this *Router) ForwardPacket() []int {
	//fmt.Println(this.queue)
	if this.queue.Len() <= 0 {
		return []int{}
	}
	top := heap.Pop(&this.queue).(RecordQueue)
	delete(this.records, Record{top.source, top.destination, top.timestamp})
	queue := this.soureQueue[top.destination]
	heap.Pop(&queue)
	this.soureQueue[top.destination] = queue

	return []int{top.source, top.destination, top.timestamp}
}

// 根据destination找包，二分找start和end
// 第一个大于startTime和第一个小于 endTime
func (this *Router) GetCount(destination int, startTime int, endTime int) int {
	queue := this.soureQueue[destination]
	//fmt.Println(queue)
	n := len(queue)
	start := sort.Search(n, func(i int) bool {
		return queue[i].timestamp >= startTime
	})
	end := sort.Search(n, func(i int) bool {
		return queue[i].timestamp > endTime
	})
	//fmt.Println(start,end)
	if start == -1 || end == -1 {
		return 0
	}
	return end - start
}
