package main

import "container/heap"

type PriorityQueue []Item

type TaskManager struct {
	records   PriorityQueue
	situation map[int]int // priority修改情况
	userMap   map[int]int
}
type Item struct {
	user     int
	task     int
	priority int
}

func (p PriorityQueue) Len() int {
	return len(p)
}
func (p PriorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p PriorityQueue) Less(i, j int) bool {
	if p[i].priority == p[j].priority {
		return p[i].task > p[j].task
	}
	return p[i].priority > p[j].priority
}
func (p *PriorityQueue) Pop() interface{} {
	old := *p
	l := len(old)
	res := old[l-1]
	*p = old[0 : l-1]
	return res
}
func (p *PriorityQueue) Push(x interface{}) {
	(*p) = append((*p), x.(Item))
}
func Constructor(tasks [][]int) TaskManager {
	records := make(PriorityQueue, 0)
	situation := make(map[int]int)
	userMap := make(map[int]int)
	for _, task := range tasks {

		records = append(records, Item{task[0], task[1], task[2]})
		situation[task[1]] = task[2]
		userMap[task[1]] = task[0]
	}
	heap.Init(&records)
	//fmt.Println(records)
	return TaskManager{records, situation, userMap}
}

// 给用户userid 新增 taskid
func (tm *TaskManager) Add(userId int, taskId int, priority int) {
	heap.Push(&tm.records, Item{userId, taskId, priority})
	tm.situation[taskId] = priority
	tm.userMap[taskId] = userId
}

// 修改taski的priority
func (tm *TaskManager) Edit(taskId int, newPriority int) {
	tm.situation[taskId] = newPriority
	heap.Push(&tm.records, Item{tm.userMap[taskId], taskId, newPriority})
}

// 删除taskid
func (tm *TaskManager) Rmv(taskId int) {
	delete(tm.situation, taskId)
	delete(tm.userMap, taskId)
}

// 返回所有用户priority最高的taskid，然后删除
func (tm *TaskManager) ExecTop() int {
	res := -1
	for tm.records.Len() > 0 {
		cur := heap.Pop(&tm.records).(Item)
		if _, ok := tm.situation[cur.task]; !ok || ok && tm.situation[cur.task] != cur.priority {
			continue
		}
		if _, ok := tm.userMap[cur.task]; !ok || ok && tm.userMap[cur.task] != cur.user {
			continue
		}
		if tm.situation[cur.task] == cur.priority {
			res = cur.user
			delete(tm.situation, cur.task)
			delete(tm.userMap, cur.task)
			break
		}
	}
	return res
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * obj := Constructor(tasks);
 * obj.Add(userId,taskId,priority);
 * obj.Edit(taskId,newPriority);
 * obj.Rmv(taskId);
 * param_4 := obj.ExecTop();
 */
