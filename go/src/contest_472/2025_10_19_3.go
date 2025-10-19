package contest472

func LexGreaterPermutation(s string, target string) string {
	n := len(s)
	ans := make([]byte, n)
	records := make([]int, 26)
	for _, c := range []byte(s) {
		records[c-'a']++
	}
	//tmp := s
	var dfs func(pos int, flag bool) bool
	dfs = func(pos int, flag bool) bool {
		if pos == n {
			return !flag
		}
		if !flag {
			p := pos
			for k := 0; k < 26; k++ {
				for cnt := records[k]; cnt > 0; cnt-- {
					ans[p] = byte('a' + k)
					p++
				}
			}
			return true
		}
		tb := target[pos]
		start := int(tb - 'a')
		for k := start; k < 26; k++ {
			if records[k] == 0 {
				continue
			}
			if k == start {
				records[k]--
				ans[pos] = byte('a' + k)
				if dfs(pos+1, true) {
					return true
				}
				records[k]++
			} else {
				records[k]--
				ans[pos] = byte('a' + k)
				p := pos + 1
				for kk := 0; kk < 26; kk++ {
					for cnt := records[kk]; cnt > 0; cnt-- {
						ans[p] = byte('a' + kk)
						p++
					}
				}
				records[k]++
				return true
			}
		}
		return false
	}
	if dfs(0, true) {
		return string(ans)
	}
	return ""
}
