package main

import (
	"container/heap"
)

/*
 * @lc app=leetcode.cn id=2353 lang=golang
 *
 * [2353] 设计食物评分系统
 */

// @lc code=start
type FoodRatings struct {
	foodToCuisine map[string]string
	foodToRating  map[string]int
	cuisineToFood map[string]*MaxHeap
}

func Constructor(foods []string, cuisines []string, ratings []int) FoodRatings {
	foodToCuisine := make(map[string]string)
	foodToRating := make(map[string]int)
	cuisineToFood := make(map[string]*MaxHeap)

	for i, food := range foods {
		foodToCuisine[food] = cuisines[i]
		foodToRating[food] = ratings[i]
		if _, ok := cuisineToFood[cuisines[i]]; !ok {
			cuisineToFood[cuisines[i]] = &MaxHeap{}
			heap.Init(cuisineToFood[cuisines[i]])
		}
		heap.Push(cuisineToFood[cuisines[i]], &Food{food, ratings[i]})
	}

	return FoodRatings{foodToCuisine, foodToRating, cuisineToFood}
}

func (t *FoodRatings) ChangeRating(food string, newRating int) {
	cuisine := t.foodToCuisine[food]
	t.foodToRating[food] = newRating

	// 更新堆中的评分
	heap.Push(t.cuisineToFood[cuisine], &Food{food, newRating})
}

func (t *FoodRatings) HighestRated(cuisine string) string {
	maxHeap := t.cuisineToFood[cuisine]
	for {
		top := heap.Pop(maxHeap).(*Food)
		if t.foodToRating[top.name] == top.rating {
			heap.Push(maxHeap, top)
			return top.name
		}
	}
}

type Food struct {
	name   string
	rating int
}

type MaxHeap []*Food

func (h MaxHeap) Len() int { return len(h) }
func (h MaxHeap) Less(i, j int) bool {
	return h[i].rating > h[j].rating || (h[i].rating == h[j].rating && h[i].name < h[j].name)
}
func (h MaxHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *MaxHeap) Push(x interface{}) {
	*h = append(*h, x.(*Food))
}

func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	item := old[n-1]
	*h = old[0 : n-1]
	return item
}

// @lc code=end
