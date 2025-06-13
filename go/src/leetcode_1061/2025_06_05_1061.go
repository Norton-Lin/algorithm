package main

/*
 * @lc app=leetcode.cn id=1061 lang=golang
 *
 * [1061] 按字典序排列最小的等效字符串
 */

// @lc code=start
// 基于s1，s2结果，把baseStr换成字典序最小的
// 并查集
type UnionFind struct {
	parent []int
	rank   []int
}

func NewUnionFind(n int) *UnionFind {
	uf := &UnionFind{
		parent: make([]int, n),
		rank:   make([]int, n),
	}
	for i := 0; i < n; i++ {
		uf.parent[i] = i
		uf.rank[i] = i
	}
	return uf
}
func (uf *UnionFind) Find(x int) int {
	if uf.parent[x] != x {
		uf.parent[x] = uf.Find(uf.parent[x])
	}
	return uf.parent[x]
}
func (uf *UnionFind) Union(x, y int) {
	rootX := uf.Find(x)
	rootY := uf.Find(y)
	if rootX == rootY {
		return
	}
	if uf.rank[rootX] > uf.rank[rootY] {
		uf.parent[rootX] = rootY
	} else if uf.rank[rootX] < uf.rank[rootY] {
		uf.parent[rootY] = rootX
	}
}
func (uf *UnionFind) Connected(x, y int) bool {
	return uf.Find(x) == uf.Find(y)
}
func SmallestEquivalentString(s1 string, s2 string, baseStr string) string {
	uf := NewUnionFind(26)
	n := len(s1)
	ans := make([]rune, 0)
	for i := 0; i < n; i++ {
		//fmt.Println(int(s1[i]-'a'), int(s2[i]-'a'))
		if !uf.Connected(int(s1[i]-'a'), int(s2[i]-'a')) {
			uf.Union(int(s1[i]-'a'), int(s2[i]-'a'))
		}
	}
	//fmt.Println(uf)
	for _, c := range baseStr {
		//fmt.Println(rune(uf.Find(int(c-'a'))))
		ans = append(ans, rune('a'+uf.Find(int(c-'a'))))
	}
	return string(ans)
}

// @lc code=end
