package contest441

// 相同值最近下标
func SolveQueries(nums []int, queries []int) []int {
	records := make(map[int][]int)
	l := len(nums)
	ans := make([]int, len(queries))
	for i, num := range nums {
		records[num] = append(records[num], i)
	}
	for i, query := range queries {
		record := records[nums[query]]
		n := len(record)
		index := 0
		if n == 1 {
			ans[i] = -1
			continue
		}
		for record[index] != query {
			index++
		}
		if index == n-1 {
			//fmt.Println(query-record[n-2], n-query+record[0])
			ans[i] = min(query-record[n-2], l-query+record[0])
		} else if index == 0 {
			//fmt.Println(record)
			//fmt.Println(index,query,record[1]-query, query+l-record[n-1])
			ans[i] = min(record[1]-query, query+l-record[n-1])
		} else {
			//fmt.Println(query-record[index-1], record[index+1]-query)
			ans[i] = min(query-record[index-1], record[index+1]-query)
		}

	}
	return ans
}
