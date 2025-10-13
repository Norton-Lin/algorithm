package contestd167

import (
	"sort"
)

type edge struct {
	u, v, d int
}

func MaxPartitionFactor(points [][]int) int {
	n := len(points)
	if n == 2 {
		return 0
	}
	edges := make([]edge, 0)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			d := abs(points[i][0]-points[j][0]) + abs(points[i][1]-points[j][1])
			edges = append(edges, edge{i, j, d})
		}
	}
	sort.Slice(edges, func(i, j int) bool {
		return edges[i].d < edges[j].d
	})
	// fmt.Println(edges)
	left, right := 0, edges[len(edges)-1].d
	ans := 0
	for left <= right {
		// fmt.Println(left, right)
		mid := (left + right) / 2
		uf := newUnionSet(n)
		for _, e := range edges {
			if e.d >= mid {
				uf.union(e.u, e.v)
			}
		}
		set := map[int]struct{}{}
		for i := 0; i < n; i++ {
			set[uf.find(i)] = struct{}{}
		}
		if len(set) >= 2 {
			ans = mid
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return ans
}

func abs(a int) int {
	if a < 0 {
		a = -a
	}
	return a
}

type unionSet struct {
	parent []int
}

func newUnionSet(n int) *unionSet {
	p := make([]int, n)
	for i := range p {
		p[i] = i
	}
	return &unionSet{p}
}

func (u *unionSet) find(x int) int {
	if u.parent[x] != x {
		u.parent[x] = u.find(u.parent[x])
	}
	return u.parent[x]
}

func (u *unionSet) union(x, y int) {
	px, py := u.find(x), u.find(y)
	if px != py {
		u.parent[px] = py
	}
}
