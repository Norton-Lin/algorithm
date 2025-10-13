package contestd167

import "sort"

type ExamTracker struct {
	records []int
	pre     []int64
}

func Constructor() ExamTracker {
	records := make([]int, 0)
	pre := make([]int64, 0)
	pre = append(pre, int64(0))
	return ExamTracker{records, pre}
}

// 拿分
func (this *ExamTracker) Record(time int, score int) {
	this.records = append(this.records, time)
	this.pre = append(this.pre, this.pre[len(this.pre)-1]+int64(score))
}

// 求总分，二分
func (this *ExamTracker) TotalScore(startTime int, endTime int) int64 {
	startIndex := sort.SearchInts(this.records, startTime)
	endIndex := sort.SearchInts(this.records, endTime+1)
	return this.pre[endIndex] - this.pre[startIndex]
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Record(time,score);
 * param_2 := obj.TotalScore(startTime,endTime);
 */
